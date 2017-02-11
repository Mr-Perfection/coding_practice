"""
List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes
at each depth (e.g., if you have a tree with depth 0, you'll have 0 linked lists).

            5
        2       6
     1     3  4    5

my algorithm as below:
1. check if there exists a tree.
2. use hashmap(level_number, list(nodes)) to keep track of nodes
3. use preorder traversal to keep track of level_number
4. get the max depth of tree for creating a linkedlist
5. create list of linkedlists based on lists from hashmap
Let's get started!
"""

def preorder_traversal_modified(head,level,table):
    # return -1 if head is None
    if not(head):
        return -1
    max_level = level
    # right tree
    max_level = max(max_level, preorder_traversal_modified(head.right,level+1,table))
    # left tree
    max_level = max(max_level, preorder_traversal_modified(head.left,level+1,table))
    # store the node into the list of that level
    table[level].append(head)
    return max_level
def list_of_depths(head):
    if not(head):
        return None
    # initializaitons go here.
    table = {} #{key,value} = {level_number: list(nodes)}
    ll = [] #list of linkedlists
    # get max_level value from function below
    max_level = preorder_traversal_modified(head,0,table)

    # create a list of linkedlist
    for i in range(max_level+1):
        l = table[i]
        ll.append(l)
    # return the list
    return ll
