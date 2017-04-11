# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def helper(self,root,res,val):
        # base case
        if not(root.left) and not(root.right):
            res.append(val)
            return

        # if root.left exists
        if root.left:
            self.helper(root.left,res,val*10+root.left.val)
        # if root.right exists
        if root.right:
            self.helper(root.right,res,val*10+root.right.val)

    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        res = []
        if not(root): return 0
        self.helper(root,res,root.val)
        return sum(res)
