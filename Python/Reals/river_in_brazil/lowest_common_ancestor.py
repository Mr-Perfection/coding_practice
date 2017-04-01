# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode

        Approach #1: store ancestors O(n), O(n)
        * recurse through a tree for each p and q seperately and compare two ancestors lists

        Approach #2: max and min
        * pass p,q into fn(root,p,q)
        * if root.val < min(p,q)
            * return fn(root.right,p,q)
        * if root.val > max(p.q)
            * return fn(root.left,p,q)
        * return root

        """
        if not(root): return None
        if root.val < min(p.val,q.val): return self.lowestCommonAncestor(root.right,p,q)
        if root.val > max(p.val,q.val): return self.lowestCommonAncestor(root.left,p,q)
        return root
        
class Solution(object):
    def list_of_ancestors(self,root,lst,target):
        if not(root): return False
        if root == target:
            lst.append(root)
            return True
        if self.list_of_ancestors(root.left,lst,target) or\
           self.list_of_ancestors(root.right,lst,target):
            lst.append(root)
            return True
        return False
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        if not(root): return None
        """
        approach #1 store ancestors time: O(n) space: O(n) with buffer
        store the ancestor nodes of each p and q node
        then compare if there exist a match, return a last match

        approach #2 check ancestors time O(n^2) space: O(n)
        keep track if p and q are both found
        if they are both found, check ancestors from root to p and q
        """
        lst1,lst2 = [],[]
        self.list_of_ancestors(root,lst1,p)
        self.list_of_ancestors(root,lst2,q)
        set2 = set(lst2)
        for i in range(len(lst1)):
            if lst1[i] in set2:
                return lst1[i]
        return None
