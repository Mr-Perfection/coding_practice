"""
Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an algo-
rithm to create a binary search tree with minimal height.


input: [1,2,3,4,5] or [1,2,3,4,5,6]
output:
        3
     2     5
   1     4

...

algorithm is as follows:
    1. insert into the tree the middle element of the array
    2. repeat 1. recursively for your left subtree
    3. repeat 1. recursively for your right subtree
"""

# implements the algorithm from above.
def minimal_tree_helper(arr,left,right):
    if left >= right:
        return None
    mid = (left+right)/2
    node = Node(mid)
    node.left = minimal_tree_helper(arr,left,mid-1) # get left subtree recursively
    node.right = minimal_tree_helper(arr,mid+1,right) # get right subtree recursively
    return node #return the node


# the main function for minimal_tree
# return head
# Time: O(n log n) because we are diving the n = len(arr) by 2 every recursion
def minimal_tree(arr):
    n = len(arr)
    return minimal_tree_helper(arr,0,len(arr)-1)
    # mid ->left
