# Scenario 2

N canal barges competing for M spaces inside the lock, where M < N.

i) Give a brief description of the issues and problems that need to be resolved and state any assumptions you make about the scenario. (5 marks)
ii) Using semaphores develop a "pseudo code" program (in the style used in the lecture notes) to solve this scenario. Provide a brief description of the purpose of each semaphore used in your program. (10 marks)

## Issues, Problems and Assumptions

- There are less spaces in the lock than there are canal barges.
- Need to avoid more barges than available spaces.
- Traffic control for the lock.
  - One barge out, another one in.
  - Once a barge moves out of the lock, freeing up a space another barge in the queue will be told to proceed.
- General Semaphore (more than one space (lock)) (counting).

## Pseudo-code

```pseudocode

```

### Explanation of Code

- ...