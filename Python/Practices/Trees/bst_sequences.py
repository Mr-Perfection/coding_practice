"""
I think this is a bad question. Need more details wtf?
My solution is wrong...
BST Sequences: A binary search tree was created by traversing through an array from left to right and inserting each element.
Given a binary search tree with distinct elements, print all possible arrays that could have led to this tree.
EXAMPLE
Input:
    2
1        3

preorder traversal:
2 1 3
preorder modified traversal:
2 3 1
Output: {2, 1, 3}, {2, 3, 1}

Time: O(n) n is a number of nodes
Space: O(n)
"""

def preorder_traversal(root,arr):
    # base condition
    if not(root):
        return
    # print node
    arr.append(node.data)
    # recurse left node
    preorder_traversal(root.left, arr)
    # recurse right node
    preorder_traversal(root.right, arr)

def preorder_modified_traversal(root,arr):
    # base condition
    if not(root):
        return
    # print node
    arr.append(node.data)
    # recurse right node
    preorder_modified_traversal(root.right, arr)
    # recurse left node
    preorder_modified_traversal(root.left, arr)

def bst_sequences(root):
    # check if root is None'
    if not(root):
        return None

    # initializations
    result = []
    # execute inorder traversal
    result.append(preorder_traversal(root,arr))
    # execute inorder modified traversal
    result.append(preorder_modified_traversal(root,arr))

    return result
