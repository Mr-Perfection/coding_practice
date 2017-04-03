# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):

    def zigzag(self, root, level, sol):

        if not(root): return

        if level + 1 > len(sol):
            sol.append([root.val])
        else:
            if level % 2 == 0:
                sol[level].append(root.val)
            else:
                sol[level].insert(0, root.val)
        self.zigzag(root.left, level+1, sol)
        self.zigzag(root.right, level+1, sol)
    def zigzagLevelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]

        Approach: level based traversal
        * keep track of level
        * zigzag?
            * every odd level, reversed
            * every even level, no reversed

        zigzag(root, level, sol[][])
            if not(root) return
            if level + 1 > len(sol)
                sol.append([root.val])
            else
                if level is even, add root.val to front sol[level]
                else add root.val to end sol[level]
            zigzag(root.left,level+1,sol[][])
            zigzag(root.right,level+1,sol[][])

        """
        sol = []
        self.zigzag(root, 0, sol)
        return sol
