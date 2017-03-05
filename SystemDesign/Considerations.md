* Failures: Essentially any part of a system can fail. You'll need to plan for many or all of these failures.

* Availability and Reliability: Availability is a function of the percentage of time the system is operational. Reliability is a function of the probability that the system is operational for a certain unit of time.

* Read-heavy vs. Write-heavy: Whether an application will do a lot of reads or a lot of writes impacts the design. If it's write-heavy, you could consider queuing up the writes (but think about potential failure here!). If it's read-heavy, you might want to cache. Other design decisions could change as well.
e.g:
if it is read-heavy, also considering master-slave replication.
If it is write-heavy, master-master replication

* Security: Security threats can, of course, be devastating for a system.Think about the types of issues a system might face and design around those.
