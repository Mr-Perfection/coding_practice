n, m = [int(x) for x in input().split()]
coinValues = [int(x) for x in input().split()]
memo = {}
def coinChange(index, coinValues, change):
    key = (index, change)
    if key in memo:
        return memo[key]
    elif change == 0:
        memo[key] = 1
    elif change < 0 or index >= len(coinValues):
        memo[key] = 0
    else:
        memo[key] = coinChange(index, coinValues, change - coinValues[index]) + coinChange(index + 1,coinValues, change)
    return memo[key]

print(coinChange(0, coinValues, n))


"""dont understand why we use heappush and heappop? Is it because we have to get them in alphabetical order?"""
"""Dijkstra algorithm"""
"""Approach:
    - store the neighboring vertices and their values into dictionary
    - create queue with starting vertex and set to keep track of vertices included in a shortest path

    """
# create a dictionary that stores a tuple(dest, cost)
# create a set to store the visited vertices
# create a priority queue to traverse through vertices (src, paths, cost)
# store (dest, cost) into dictionary
# traverse through the queue
# if the current vertex is end, return result
# traverse through the dictionary[src]'s tuples

from collections import defaultdict
from heapq import *

def dijkstra(edges,start,end):
    """
    create a dictionary has a list (dest, cost) as a value and src as     a key.
    """
    data = defaultdict(list)
    for src,dest,cost in edges:
        data[src].append((dest,cost))
    """
    create a queue with a (startingVertex, cost, neighbors[])
    create a set to check already visited vert
    """
    queue,visited = [(start,0,())], set()

    """
    dequeue the queue until it is empty
    add to the visited vertices if src vertex not found

    """
    while queue:
        (src,cost,path) = heappop(queue)
        if src not in visited:
            visited.add(src)
            path = (src,path)
            if src == end:
                return (cost,path)
            for vertex,c in data.get(src,()):
                if vertex not in visited:
                    heappush(queue,(vertex,cost+c,path))
    return float("inf")

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

    print("=== Dijkstra ===")
    print(edges)
    print("A -> E:")
    print(dijkstra(edges, "A", "E"))
    print("F -> G:")
    print(dijkstra(edges, "F", "G"))


graph = {'A': set(['B','C']),
         'B': set(['A','D','E']),
         'C': set(['A','F']),
         'D': set(['B']),
         'E': set(['B','F']),
         'F': set(['C','E'])}

"""Depth First Search:
    - Mark the current vertex as visited
    - Explore each adjacent vertex of current vertex that is not included in the visited set
"""
def dfs(graph, start):
    visited, stack = set(), [start]
    while stack:
        vertex = stack.pop()
        if vertex not in visited:
            visited.add(vertex)
            print(visited)
            stack.extend(graph[vertex] - visited)
    return visited
def dfs(graph, start,visited=None):
    if visited is None:
        visited = set()
    visited.add(start)
    for next in graph[start] - visited:
        dfs(graph,next, visited)
    return visited

if __name__ == "__main__":
    graph = {'A': set(['B','C']),
         'B': set(['A','D','E']),
         'C': set(['A','F']),
         'D': set(['B']),
         'E': set(['B','F']),
         'F': set(['C','E'])}
    print(dfs(graph, 'A'))
"""
Find all possible paths from start to end
"""
# create a stack that stores (start, path())
# iterate through stack until it becomes empty
# iterate through adjacent vertices of this vertex excluding those in path
def dfsPath(graph, start, goal):
    stack = [(start, [start])]
    while stack:
        (vertex,path) = stack.pop()
        for next in graph[vertex] - set(path):
            if next == goal:
                yield path + [next]
            else:
                stack.append((next, path + [next]))

if __name__ == "__main__":
    graph = {'A': set(['B','C']),
         'B': set(['A','D','E']),
         'C': set(['A','F']),
         'D': set(['B']),
         'E': set(['B','F']),
         'F': set(['C','E'])}

    print(list(dfsPath(graph, 'A', 'F')))


"""Breadth First Search:"""
def bfs(graph, start):
    # create a visited set and queue for breadth first search
    visited, queue = set(), [start]
    while queue:
        vertex = queue.pop(0)
        if vertex not in visited:
            visited.add(vertex)
            print(vertex)
            queue.extend(graph[vertex] - visited)
    return visited

def bfsPaths(graph, start):
	queue = [(start, [start])]
	while queue:
		(vertex, path) = queue.pop(0)
		for next in graph[vertex] - set(path):
			if next == end:
				yield path + [next]
			else:
				queue.append((next,path + [next]))
def shortest_path(graph, start, goal):
    try:
        return next(bfs_paths(graph, start, goal))
    except StopIteration:
        return None

shortest_path(graph, 'A', 'F') # ['A', 'C', 'F']






