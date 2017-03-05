## MapReduce is used widely in system design to process large amounts of data. As its name suggests, a MapReduce program requires you to write a Map step and a Reduce step. The rest is handled by the system.
1. The system splits up the data across different machines.
2. Each machine starts running the user-provided Map program.
3. The Map program takes some data and emits a <key ,value> pair.
4. The system-provided Shuffle process reorganizes the data so that all <key, value> pairs associated with a given key go to the same machine, to be processed by Reduce.
5. The user-provided Reduce program takes a key and a set of associated values and "reduces" them in some way, emitting a new key and value. The results of this might be fed back into the Reduce program for more reducing.


## Map -> Shuffle -> Reduce
