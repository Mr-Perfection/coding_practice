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

    #
