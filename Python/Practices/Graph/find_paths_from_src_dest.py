# find all paths from src to dest
"""
A: [B,C,D]
B: [A,D]
C: [A,B,D]
D: [A]

"""

"""
([],[A],{},[A,D],2)
([],[A,B],{A},[A,D],1)
([],[A,B,A],{A,B},A,[A,D],0)
([],[A,B],{A,B},D,[A,D],1)
([],[A,B,D],{A,B},D,[A,D],0)
([ABD,],[A,B,D],{A,B},D,[A,D],0)
([ABD,],[A,B,D],{A},D,[A,D],0)
"""

# point = (src,dest)
# n^2
def find_all_paths(paths,path,visited,src,point,steps):
    # check steps become 0
    #print(path,visited,steps)
    if steps == 0:
        # if path contains src and dest
        if all(x in path for x in point):
            return 1
        else:
            return 0
    # check if src is not in visited
    result = 0
    if src not in visited:
        # add src to visited
        visited.add(src)
        # iterate through edges of src
        for edge in paths[src]:
            # add edge to path
            path.append(edge)
            # recurse with steps-1
            result += find_all_paths(paths,path,visited,edge,point,steps-1)
            # remove edge from path
            path.pop()
        # remove src from visited
        visited.remove(src)
    return result
graph = {
    'A': ['B','C','D','F'],
    'B': ['A','D'],
    'C': ['A','B','D'],
    'F': ['A','D'],
    'D': ['A']
}
paths,src,dest,visited = [],'A','D',set()
point = (src,dest)
steps = 2
print(find_all_paths(graph,[],visited,src,point,steps+1))
