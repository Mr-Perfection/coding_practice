# Threads and Locks

## Threads in Python
```py
#!/usr/bin/python

import thread
import time

# Define a function for the thread
def print_time( threadName, delay):
   count = 0
   while count < 5:
      time.sleep(delay)
      count += 1
      print "%s: %s" % ( threadName, time.ctime(time.time()) )

# Create two threads as follows
try:
   thread.start_new_thread( print_time, ("Thread-1", 2, ) )
   thread.start_new_thread( print_time, ("Thread-2", 4, ) )
except:
   print "Error: unable to start thread"

while 1:
   pass

```

## Thread vs. Process
* A process is an independent entity to which system resources (CPU time and memory) are allocated, and one process cannot access the variables and data structures of another process. But inter-process communications have to be used e.g pipes.
* Thread exists within a process and shares the process' resources (including heap space). Each thread still has its own registers and its own stack, but other threads can read and write the heap memory.

## Deadlock

* A deadlock is a situation where a thread is waiting for an object lock that another thread holds, and this second thread is waiting for an object lock that the first thread holds (or an equivalent situation with several threads). Since each thread is waiting for the other thread to relinquish a lock, they both remain waiting forever.The threads are said to be deadlocked.
