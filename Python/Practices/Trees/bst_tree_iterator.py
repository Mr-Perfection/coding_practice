# Definition for a  binary tree node
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
"""
                        7
                3               9
            1       5       8       10


"""
class BSTIterator(object):

    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.root = root
        self.stack = []
        self.push_nodes(root, self.stack)

    def hasNext(self):
        """
        :rtype: bool
        """
        return self.stack


    def next(self):
        """
        :rtype: int
        """
        if self.hasNext():
            temp = self.stack.pop()
            self.push_nodes(temp.right,self.stack)
            return temp.val
        else:
            return -1

    def push_nodes(self, root, stack):
        while root:
            self.stack.append(root)
            root = root.left






# Your BSTIterator will be called like this:
# i, v = BSTIterator(root), []
# while i.hasNext(): v.append(i.next())
