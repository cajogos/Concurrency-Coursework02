# Question 3 - Answers

## a) Explain why the `Buffer` class (lines 1 - 34) is a "secure" monitor (4 marks)

- All of the attributes of Buffer are encapsulated to itself by the usage of the private accessor. This stops its variables from being accessible outside of the monitor, and ensures they are only altered via its procedures and functions.
- At least one of its method is synchronized which enables the object's monitor procedures, and all of the public methods of Buffer are synchronized and treated as critical sections, ensuring mutually exclusive execution.
- All its methods have a way to add or remove processes from the monitor's queue, using the wait() and notifyAll() methods of the Object class.
- The Buffer class is a passive object, it does nothing by itself, only executes when one of its visible methods are called by some process.

## b) In the `Buffer`'s `put` method, what is the purpose of the `while-loop` (lines 21 - 26)? What is the effect of the `while-loop`? (4 marks)

- The while-loop in the buffer's put method is to make the application wait until there is no new data, in other words, the buffer's content is taken by a consumer thread.
- The wait() method will tell the thread with the monitor's lock to wait its turn, by being put into the queue, until the condition of the while-loop is satisfied.



## c) Assume that the `Buffer`'s `new_data` variable is `false`, the `Producer` thread `p1` is "sleeping", and the `Consumer` thread `c1` starts to execute line 70 (`int data = buffer.take();`). What happens to the `Consumer` thread `c1`? (4 marks)

- The Consumer thread is in RUNNABLE  calling the take method whilst the new_data variable is false, this will cause for the consumer thread to fall into a WAITING state.
- This is because the new_data variable is currently waiting to be changed by the Producer thread.
- Causes two scenarios: If the Producer thread is eventually awaken and tries to run the put method it will change new_data to true and continue then Consumer will return to RUNNABLE state.



## d) In the definition of the `Buffer`'s take method (lines 6 - 17), which lines of the method does the monitor's synchronisation lock change its status, e.g. from locked to unlocked and/or unlocked to locked? Further, state which lock status change or changes happen on those lines. (3 marks)

[...]