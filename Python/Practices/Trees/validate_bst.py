"""
Validate BST: Implement a function to check if a binary tree is a binary search tree.

Are there duplicates?
is it valid that left <= root < right
            6
    5               8
3       6       5       9
my algorithm as follows:
    validate_bst(root)
    1. base case: if root is null, return True
    2. check if root data is > left node data and root data < right node data
    3. call check_ancestor. If returns False, return False.
    4. execute preorder traversal

    check_ancestor(root)
    1. check if root.ancestor != right node data and root.ancestor != left node data

    Time: O(n) if tree is not balanced and n is total number of nodes
    Space: O(n)
"""

class Node:
    def __init__(self,data):
        self.data = data
        self.right = None
        self.left = None
        self.ancestor = None

def check_ancestor(root):
    if not(root.ancestor):
        return True
    if root.right:
        if root.right.data == root.ancestor.data:
            return False
    if root.left:
        if root.left.data == root.ancestor.data:
            return False
    return True

def validate_bst(root):
    # check if root is None
    if not(root):
        return True
    # if right is None, only traverse left
    if not(root.right) and root.left:
        if check_ancestor(root):
            root.right.ancestor = root
            return validate_bst(root.right)
    # if left is None...
    if not(root.left) and root.right:
        if check_ancestor(root):
            root.left.ancestor = root
            return validate_bst(root.left)
    # check if root.data > left data and root data < right node data
    if root.data > root.left.data and root.data < root.right.data:
        if check_ancestor(root):
            root.right.ancestor,root.left.ancestor = root, root
            return validate_bst(root.left) and validate_bst(root.right)
    return False


"""
best algorithm: Min and Max solution
Time: O(n)
Space: O(log n)

BST means...
1. left.data <= current.data < right
2. left subtree has to be less or equal than current and right subtree is greater than current
"""

"""
params:
    m = minimum
    n = maximum
"""
def validate_bst_helper(root,m,n):

    if not(root):
        return True
    # check if m and n are present and follow (1)
    if (m and root.data < m.data) or (n and root.data >= n.data):
        return False
    # call itself recursively with its maximum and minimum. Set root as minimum for right tree and set root as maximum for left.
    return validate_bst_helper(root.left, m, root) and validate_bst_helper(root.right, root, n)
def validate_bst(root):
    if not(root):
        return True
    return validate_bst_helper(root,None,None)



# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):

    def helper(self,root,mx,mn):
            if not(root): return True
            # if root.value is less than min.value
            if mn and root.val <= mn.val:
                return False
            # if root.value is greater than max.value
            if mx and root.val >= mx.val:
                return False
            return self.helper(root.left,root,mn) and self.helper(root.right,mx,root)
    def isValidBST(self, root):


        """
        :type root: TreeNode
        :rtype: bool
        """
        return self.helper(root,None,None)
        
