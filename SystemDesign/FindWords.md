**Given a list of millions of documents, how would you find all documents that contain a list of words? The words can appear in any order, but they must be complete words. That is, "book" does not match "bookkeeper."**
* Step 1: start small.
1. Think small. Assume that we have a few documents.
One of the approaches is pre-process the documents and create a hash table of indexes.
"Stephen": {doc1,doc2,doc3...}
"Lee": {doc1,doc3,doc5...}

* Step 2: Identify problems as it scales to millions of docs.
1. How will we divide up our hash table? We could divide it up by keyword, such that a given machine contains the full document list for a given word. Or, we could divide by document, such that a machine contains the keyword mapping for only a subset of the documents.
2. Once we decide how to divide up the data, we may need to process a document on one machine and push the results off to other machines. What does this process look like? (Note: if we divide the hash table by document, this step may not be necessary.)
3. We will need a way of knowing which machine holds a piece of data. What does this lookup table look like, and where is it stored?

* Step 3: Divide up the words alphabetically by keyword, so that each machine controls a range of words (after...apple)
