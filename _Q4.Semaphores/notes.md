# Semaphores

## Definitions

- A **Semaphore** is an integer variable which can take only non-negative values. (s >= 0)
- **Binary Semaphores** can only have the values 0 or 1.
  - Also known as mutex
- **General Semaphores** can have any value greater than 0.
  - Usually defined with a maximum value that must not be exceeded.
  - Also known as "counting" semaphore.

## Semaphore Operations

Only operations permissible are:

- **Claim:** "lock" a semaphore: `s.claim()`
  - Synonyms: `s.acquire()`. `wait(s)` and `P(s)`
  - If `s > 0` then `s = s - 1` and the process continues. Otherwise the process is suspended on `s`, possibly using a "busy wait loop".
- **Release:** "unlock" a semaphore: `s.release()`
  - Synonyms: `signal(s)` and `V(s)`
  - If some process `P` has been suspended by a previous `s.claim()` then wake up `P`, otherwise `s = s + 1`.
  - If a number of processes have been suspended on `s` then select one of them to be woken up, the others remain suspended.
  - For binary semaphores the definition of `s.release()` is changed to `s = 1`.
- **Initialise:** Set an initial value for a semaphore as either "locker" `(s = 0)` or "unlocked" `(s >= 1)`.
  - `s = new BinarySemaphore(v)` `| 0 <= v <= 1 |`
  - `s = new GeneralSemaphore(MAX, v)` `| 0 <= v <= MAX |`

## Issues to solve with Semaphores

- **Atomicity** of the `claim` and `release` operations.
  - `s.claim()` and `s.release()` MUST BE atomic, primitive and uninterruptible.
  - Only one operation succeeds and the others get blocked.
- **Waiting** within a `claim` operation.
  - "blocking wait" is preferred to "busy wait" because of efficiency.
- **Blocking and Waking** `claiming` processes.
  - "blocking" of a process claiming a locked semaphore.
  - "wake-up" strategy for blocked processes on a newly unlocked semaphore.
  - FIFO queue with each semaphore.

