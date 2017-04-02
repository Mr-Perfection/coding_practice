# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def search_paths(self, root, sum, path, paths):
        if not(root): return
        sum -= root.val

        if sum < 0: return
        path.append(root.val)
        if sum == 0:
            paths.append(path[:])

        self.search_paths(root.left, sum, path, paths)
        self.search_paths(root.right, sum, path, paths)
        path.pop()


    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: List[List[int]]

        Assumptions:
        root to leaf paths (root has to be included)
        return list of all the possible paths.
        Path is a list of integers that sum up to sum.

        Approach #1: DFS
        search_paths(root, sum, path, paths)
            if root == null, return
            sum -= root.val
            if sum < 0, return
            path.append(root.val)
            if sum == 0,
                paths.append(path)
                path.pop()
                return
            search_paths(root.left, sum, path, paths)
            search_paths(root.right, sum, path, paths)
            path.pop()

        """
        path = []
        paths = []
        self.search_paths(root, sum, path, paths)
        return paths


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def search_paths(self, root, sum, path, paths):
        if not(root): return

        path.append(root.val)
        if not(root.left) and not(root.right) and sum == root.val:
            paths.append(path[:])
        if root.left:
            self.search_paths(root.left, sum-root.val, path, paths)
        if root.right:
            self.search_paths(root.right, sum-root.val, path, paths)
        path.pop()


    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: List[List[int]]

        Assumptions:
        root to leaf paths (root has to be included)
        return list of all the possible paths.
        Path is a list of integers that sum up to sum.

        Approach #1: DFS
        search_paths(root, sum, path, paths)
            if root == null, return
            sum -= root.val
            if sum < 0, return
            path.append(root.val)
            if sum == 0,
                paths.append(path)
                path.pop()
                return
            search_paths(root.left, sum, path, paths)
            search_paths(root.right, sum, path, paths)
            path.pop()

        """
        path = []
        paths = []
        self.search_paths(root, sum, path, paths)
        return paths
