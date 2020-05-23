# Scenario 1

Several canal barges competing for one mooring space.

i) Give a brief description of the issues and problems that need to be resolved and state any assumptions you make about the scenario. (5 marks)
ii) Using semaphores develop a "pseudo code" program (in the style used in the lecture notes) to solve this scenario. Provide a brief description of the purpose of each semaphore used in your program. (10 marks)

## Issues, Problems and Assumptions

- Many different canal barges trying to fill one single mooring space.
  - There needs to be some sort of FIFO queue system in place.
- Binary Semaphore as there's only one lock (mutex).
- Need to make sure that two canal barges don't try and take the mooring space at the same time (crash).
  - They must be first be told it's okay to go.

## Pseudo-code

```pseudocode
Program Scenario1
{

    process Barge(BinarySemaphore space)
    {
        while ( true )
        {
            space.claim();
            use_mooring_space; // Critical section
            space.release();
        }
    }

    main()
    {
        final int UNLOCKED = 1;

        // Moooring "space" is handled like a mutex (either available or not)
        BinarySemaphore space = new BinarySemaphore(UNLOCKED);

        parbegin
            Barge(space);
            ...// Several Canal "Barge" processes
            Barge(space);
        parend;
    }

} // Scenario1

```

### Explanation of Code

- For this scenario a Binary Semaphore was implemented as there is only one resource (mooring space) available for sharing.
- The Semaphore `space` is used as a mutex in this example, starting by being in unlocked state (s == 1). The first Barge process will then claim the Semaphore and decrement its value (s == 0).
- The following Barge process that tries to claim the space will go to the queue and wait its turn.
- Once the Barge process finishes using the mooring space (the critical section) it will release it (s == 1).

