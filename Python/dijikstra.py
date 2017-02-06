
    
graph = {}

def create_graph(edges):
    graph = {}
    for edge in edges:
        if edge[0] in graph:
            graph[edge[0]].append((edge[1], edge[2]))
        else:
            graph[edge[0]] = [(edge[1], edge[2])]
    
    return graph

def shortest_path(graph, start, end):
    q = [(0,start,'')]
    visited = set()
    
    while q:
        weight, node, path = q.pop()
        if node not in visited:
            visited.add(node)
            path += node + ' '
            if node == end:
                return weight, path
            for edge in graph[node]:
                if edge[0] not in visited:
                    q.append((weight + edge[1], edge[0], path))
                    q.sort(reverse=True)
        
from collections import defaultdict
from heapq import *

# Bellman Ford
# DP
def shortest_path(edges, start, end):
    # create a dictionary containing (dest, cost) and src as a key
    data = defaultdict(list)
    for src,dest,cost in edges:
        data[src].append((dest, cost))
    
    # create a priority queue with a (current, cost, adj[])
    # create a set to keep track of visited vertices
    queue, visited = [(start, 0, ())], set()
    
    # enqueuing the queue until it is empty
    # add a visted vertice if current vertice is not found
    while queue:
        (current, cost, path) = heappop(queue)
        if current not in visited:
            visited.add(current)
            path = (current, path)
            # terminating condition
            if current == end:
                return (cost, path)
            for vertex,c in data.get(current,()):
                if vertex not in visited:
                    heappush(queue, (vertex, cost + c, path))

    return float("inf")
# Given with edges between vertices, find the shortest path.
if __name__ == "__main__":
    edges = [
        ("A", "B", 7),
        ("A", "D", 5),
        ("B", "C", 8),
        ("B", "D", 9),
        ("B", "E", 7),
        ("C", "E", 5),
        ("D", "E", 15),
        ("D", "F", 6),
        ("E", "F", 8),
        ("E", "G", 9),
        ("F", "G", 11)
    ]
    graph = create_graph(edges)
    # print(shortest_path(graph, "A", "E"))
    print(shortest_path(edges, "A", "E"))
    """
    ("A", "B", 7),
    ("B", "E", 7)
    
    A -> E
    Output:
    (14, ('E', ('B', ('A', ()))))
    """
    