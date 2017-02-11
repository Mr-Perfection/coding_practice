def bfs(graph,start):
    visited,path,queue = set(),"",[start]
    while queue:
        item = queue.pop(0)
        if item not in visited:
            visited.add(item)
            path += item + " "
            for adj in graph[item]:
                if adj not in visited:
                    queue.append(adj)
    return path

def bfsShortestPath(graph, start,end):
    queue = [(start,[start])]
    lst = []
    while queue:
        (vertex,path) = queue.pop(0)
        for edge in graph[vertex] - set(path):
            if edge == end:
                lst.append(path+[edge])
            else:
                queue.append((edge,path+[edge]))
                queue.sort(reverse=True)
    return lst.pop()
def bfsPaths2(graph, start,end):
    queue = [(start, [start])]
    while queue:
        (vertex, path) = queue.pop(0)
        for next in graph[vertex] - set(path):
            if next == end:
                yield [path + [next]]
            else:
                queue.append((next,path + [next]))

if __name__ == "__main__":
    graph = {'A': set(['B','C']),
         'B': set(['A','D','E']),
         'C': set(['A','F']),
         'D': set(['B']),
         'E': set(['B','F']),
         'F': set(['C','E'])}

    print(bfs(graph, 'A'))
    print("----------------------")
    #print(dfs(graph, 'A'))
    print("----------------------")
    print(list(bfsPaths(graph, 'A','E')))
    #print(bfsPaths(graph, 'A','E'))
    #print(shortestPath(graph, 'A','E'))