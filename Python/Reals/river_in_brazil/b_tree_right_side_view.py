# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):

    def right_side(self,root,lst,level):
        if not(root): return

        if level == len(lst):
            lst.append(root.val)
        self.right_side(root.right,lst,level+1)
        self.right_side(root.left,lst,level+1)


    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not(root): return []

        res = []

        self.right_side(root,res,0)

        return res
