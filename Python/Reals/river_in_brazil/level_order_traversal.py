# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):

    def level_order_helper(self, root, level, result):

        if not(root): return

        if level >= len(result):
            result.append([root.val])
        else:
            result[level].append(root.val)

        self.level_order_helper(root.left, level+1, result)
        self.level_order_helper(root.right, level+1, result)
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        """
        Approach #1: track level & result[][]

        * base case: if root is none, return
        * if level > len of result - 1
            * append [root.val] to result
        * else
            * append root.val to result[level]

        * fn(root.left, level+1,result)
        * fn(root.right, level+1,result)

                (root, level, result[][])
                                    (3,0,[[3],[9]])
                        (9,1,[[3],[9]])         (20,1,[[3],[9]])
                    (None,2,[[3],[9]])    (15,2,[[3],[9,20]]) (15,2,[[3],[9,20]])

        """
        result = []
        level = 0
        self.level_order_helper(root,level,result)
        return result
