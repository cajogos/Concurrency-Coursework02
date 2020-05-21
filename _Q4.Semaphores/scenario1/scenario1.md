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

```

### Explanation of Code

- ...