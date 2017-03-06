"""
Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a route between two nodes.

Assumptions:
    we know start and end nodes.
my algorithm as below (use breadth first search, O(n+m), n number of vertexes and m number of edges):
    modified_bfs(start,end)
    1. Use modified breadth first search algorithm to find end node from start node
    2. return True if end node exists, else False

    route_between_node(start, end)
    Time complexity: O(n+m)
"""

class Node:
    def __init__(self, data):
        self.data = data
        self.adjacent = []

    def add(self, adj):
        self.adjacent.append(adj)
        return True

    ...

def modified_bfs(graph,start,end):
    queue,visited = graph[start],set()

    while queue:
        edge = queue.pop(0)
        if edge not in visited:
            visited.add(edge)
            if edge == end:
                return True
            for adj in graph[edge]:
                queue.append(adj)
    return False
def route_between_node(graph,start, end):
    if start == end:
        return True
    return modified_bfs(graph,start,end)








"""
Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a route between two nodes.

"""
def enqueue_edges(node,visited,graph,queue):
    for edge in graph[node]:
        if edge not in visited:
            queue.append(edge)
"""THIS FUNCTION IS USED FOR UNDIRECTED GRAPH. Bidirectional search. O(v^(e/2))"""
def is_route(src,dest,graph):
    # assume that src, dest, and graph always exist
    queue1,queue2 = [src],[dest]
    visited1,visited2 = set(),set()

    while queue1 and queu2:
        # get first node in queue
        node1,node2 = queue1.pop(0),queue2.pop(0)
        # check if node1 or node2 are in opposite visited
        if node1 in visited2 or node2 in visited1:
            return True

        if node1 not in visited1:
            visited1.add(node1)
            enqueue_edges(node1,visited,graph,queue1)

        if node2 not in visited2:
            visited2.add(node2)
            enqueue_edges(node2,visited,graph,queue2)
    return False

"""THIS FUNCTION IS USED FOR DIRECTED GRAPH. Bidirectional search. O(v^(e))"""
def is_route_bfs(src,dest,graph):
    queue = [src]
    visited = set()

    while queue:
        node = queue.pop(0)
        if node == dest:
            return True
        if node not in visited:
            visited.add(node)
            enqueue_edges(node,visited,graph,queue)
    return False

graph = {'A': set(['B','C']),
         'B': set(['A','D']),
         'C': set(['A',]),
         'D': set(['B','F']),
         'E': set(['B','D']),
         'F': set(['C'])}
src = 'A'
dest = 'E'
print(is_route_bfs(src,dest,graph))
