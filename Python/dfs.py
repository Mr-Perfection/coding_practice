def dfs(graph,start):
    visited = set()
    path,stack = "",[start]
    while stack:
        item = stack.pop()
        if item not in visited:
            visited.add(item)
            path += item + " "
            for adj in graph[item]:
                if adj not in visited:
                    stack.append(adj)
    return path
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
    # print(list(bfsPaths(graph, 'A','E')))
    #print(bfsPaths(graph, 'A','E'))
    #print(shortestPath(graph, 'A','E'))