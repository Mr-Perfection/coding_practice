**Social Network: How would you design the data structures for a very large social network like Facebook or Linkedln? Describe how you would design an algorithm to show the shortest path between two people (e.g., Me -> Bob -> Susan -> Jason -> You).**

DFS vs. BFS?

BFS because if me-> Bob -> You and me has 100 of friends, you would not want to visit all the other nodes to reach me -> Bob -> You.

Bidirectional BFS (BFS from src and dest)

```py
def bfs(graph,src):
  path,queue,visited = '',[src],set()
  while queue:
    person = queue.pop()
    if person not in visited:
      visited.add(person)
def bidirectional_bfs(graph,src,dest):

  ...

```
