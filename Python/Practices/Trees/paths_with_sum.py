"""
Paths with Sum: You are given a binary tree in which each node contains an integer value (which might be positive or negative). Design an algorithm to count the number of paths that sum to a given value. The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

target = 3
            5
    2            6
2        1

fn(2,3) = fn(2,1) + fn(1,1)
can the given value be 0?

Time: O(n^2), n = # of nodes in a tree in worst case
     O(n * log(n)) if tree is balanced
Space: O(n)
"""
def get_all_nodes(root,nodes):
    # base case
    if not(root):
        return None
    # preorder traversal
    nodes.append(root)
    # recurse left
    get_all_nodes(root.left,nodes)
    # recurse right
    get_all_nodes(root.right,nodes)

def count_paths(root,value):
    # base case
    if not(root):
        return 0
    # check if value is zero
    x = value - root.data
    # if value is zero, add 1 to the total paths
    paths = count_paths(root.left,x)+count_paths(root.right,x)
    if x == 0:
        return 1+ paths
    else:
        return paths

def paths_with_sum(root,value):
    # check if root is present
    if not(root):
        return 0
    # create a list to store all the nodes and value of total paths
    nodes,total = [], 0
    get_all_nodes(root,nodes)
    # iterate through the nodes
    for n in nodes:
    # count all the paths of a node and keep track of the total
        total += count_paths(n,value)
    return total


"""DP solution

Time: O(n), n = # of nodes in a tree in worst case
     O(n * log(n)) if tree is balanced
Space: O(n)
"""
def count_paths(root,value,table):
    # base case
    if not(root):
        return 0
    # check if value is zero
    x = value - root.data
    # if value is zero, a dd 1 to the total paths
    # check if table already has paths value
    if table[value][root.data] > -1:
        return table[value][root.data]
    paths += count_paths(root.left,x)+count_paths(root.right,x)
    if x == 0:
        table[value][root.data] = 1+ paths
    else:
        table[value][root.data] = paths
    return table[value][root.data]



"""
PREVIOUS ALGORITHMS WONT WORK.
We have to count paths for all possible sums.
It does not need to start from the root node.
Here is my O(n * log(n)) solution
"""

def paths_sum(root,values,target):
    #base case
    if not(root):
        return 0
    # initializations
    data,result = root.data, 0

    # core logic
    values.append(target)
    for i in range(0,len(values)):
        values[i] -= data
        if values[i] == 0: result += 1
    result += paths_sum(root.left,values,target) + paths_sum(root.right,values,target)

    # remove element & revert values back to previous state
    values.pop()
    for i in(range(0,len(values))): values[i] += data

    return result
