**Stock Data: Imagine you are building some sort of service that will be called by up to 1,000 client applications to get simple end-of-day stock price information (open, close, high, low). You may assume that you already have the data, and you can store it in any format you wish. How would you design the client-facing service that provides the information to client applications? You are respon- sible for the development, rollout, and ongoing monitoring and maintenance of the feed. Describe the different methods you considered and why you would recommend your approach.Your service can use any technologies you wish, and can distribute the information to the client applications in any mechanism you choose.**

* Assumptions
1. Data is already given. We do not need to update etc.
2. 1000 client applications need a way to get data from our end.

* Approach  
1. Transfer text files through FTP server.
2. SQL database & RESTful API
3. XML parsing

Proposal\#1 tranfer via FTP server
*  we could keep the data in simple text files and let clients download the data through some sort of FTP server.This would be easy to maintain in some sense, since files can be easily viewed and backed up, but it would require more complex parsing to do any sort of query. And, if additional data were added to our text file, it might break the clients' parsing mechanism.
* disadventages:
  - Very difficult to query certain stock data.

Proposal\#2 SQL relational database

* Facilitates an easy way for the clients to do query processing over the data, in case there are additional features we need to support. For example, we could easily and efficiently perform a query such as "return all stocks having an open price greater than N and a closing price less than M:'
* Rolling back, backing up data, and security could be provided using standard database features. We don't have to "reinvent the wheel," so it's easy for us to implement. Reasonably easy for the clients to integrate into existing applications. SOL integration is a standard feature in software development environments.

etc...
