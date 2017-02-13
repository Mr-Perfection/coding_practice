"""
First Common Ancestor: Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree.
Avoid storing additional nodes in a data structure. NOTE: This is not necessarily a binary search tree.

does this Node have parent property?

input: first_node, second_node
output: common ancestor node

"""
class Node:
    def __init__(self,data):
        self.parent = None
        self.left = None
        self.right = None

def first_common_ancestor(first, second):
    # traverse through the parent nodes
    while first.parent and second.parent:
        # if the common ancestor is found, return that node
        if first.parent == second.parent:
            return first.parent
        first,second = first.parent,second.parent
    # if first node has reached the root node, traverse the second node until its parent is None
    if first.parent == None and second.parent != None:
        while second.parent:
            # check if first node and second node are same
            if first == second.parent:
                return first
            second = second.parent
    # if second node is root node, traverse first node until the parent is None
    if second.parent == None and first.parent != None :
        while first.parent:
            # check if first node and second node are same
            if second == first.parent:
                return second
            first = first.parent

    return first if first == second else None

# time: O(n), n is the depth of the longer node
# space: O(1)
