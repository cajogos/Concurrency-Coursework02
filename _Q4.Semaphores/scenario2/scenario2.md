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
Program Scenario2
{

    process Barge(int id, GeneralSemaphore spaces)
    {
        while ( true )
        {
            spaces.claim();
            use_space_inside_lock; // Critical section
            spaces.release();
        }
    }


    main()
    {
        final int M = 5; // Number of spaces inside the lock

        // General (Counting) Semaphore to keep track of the amount of spaces
        // All the available spaces start as unlocked (M)
        GeneralSemaphore spaces = new GeneralSemaphore(M, M);

        parbegin
            Barge(1, spaces);
            Barge(2, spaces);
            ...// N Canal "Barge" processes competing for spaces inside the lock
            Barge(N, spaces);
        parend;
    }

} // Scenario2

```

### Explanation of Code

- For this scenario a General (Counting) Semaphore was implemented as there are a number (M) of spaces available inside the lock for an amount (N) of canal barges.
- The Semaphore was initialized with a maximum value of M (in this example 5) and starting at the same amount. This indicates that all spaces inside the lock are available at the start.
- Once a Barge process claims the `spaces` Semaphore it will decrement its value.
- Once all available spaces are taken, the next Barge process will once again decrement the Semaphore value causing it to go into a negative value, which means this process is then placed in a queue to wait its turn.
- Once a Barge process finishes using the space inside the lock (the critical section) it will release one available space by incrementing the Semaphore value.