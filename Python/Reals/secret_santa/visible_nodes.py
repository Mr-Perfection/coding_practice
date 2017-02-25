# coding exercises

# Cracking the coding interview - Object oriented - last question
# hashmap


"""
a node in a binary tree is defined "visible", if the path from the root of the tree to that node does not contain a node greater than it!


             8
    5               12

2     10         7     3


8 is visible 
5 is not visible -> 8>5
2 is not visible -> 5>2, 8>2
10 is visible -> everything from 8 to 5 to 10, is less than 10 > 8 and 10 > 5
input: root
output: number of visible nodes

8, 10, 12 -> 3

class Node:
    left
    right
    data
 O(n)
"""


def visible_node_helper(node,m,results):
    # base case: if node is null, exit
    if not(node):
        return
    # check if current node is greater than the parent of node 8 5 2 10
    if node.data > m:
        # check the entire parents if node is greater.
        # add node into results
        results.append(node) # [10]
        m = node.data

    # recurse left
    visible_node_helper(node.left,parents,results)
    # recurse right
    visible_node_helper(node.right,parents,results)
    
def visible_node(root):
    # initializations 
    # create a list for ancestors
    # create a list for output
    
    parents,results = [],[]
    
    # preorder traveral with helper method
    visible_node_helper(root,root.data,results)
    
    return len(results)
    
    

