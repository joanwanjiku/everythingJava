# Concurrency
- **Process** :- Unit of execution that has its own memory space.Process and application are same.
- Each application has its own memory space known as the heap. The heap is not shared between processes.
- **Thread** :- Unit of execution that shares memory space with other threads. Each thread has its own stack.
- A thread is a light-weight process. Threads support concurrency. 
- **Concurrency** :- Ability of a program to execute multiple tasks at the same time.
### Thread Priority
- Values from 1 to 10
- Higher the value, higher the priority
- Default priority is 5
- Creating a thread instance:- Thread t = new Thread(); Implementing Runnable interface:- Runnable r = new Runnable();
- **run() vs start()**:- run the code runs immediately but start() is a method that starts a thread.