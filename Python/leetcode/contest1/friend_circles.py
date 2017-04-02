There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.

Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.
547. Friend Circles
class Solution(object):
    def findCircleNum(self, A):
        N = len(A)
        visited = set()
        res = 0

        def dfs(number):
            for friend, direct in enumerate(A[number]):
                if direct and friend not in visited:
                    visited.add(friend)
                    dfs(friend)

        for i in range(N):
            if i not in visited:
                res += 1
                dfs(i)
        return res







# only 90 test cases pased
class Solution(object):
    def create_graph(self, rows, cols, M):
        graph = {}
        max_i = 0
        current = 0
        for i in range(rows):
            for j in range(cols):
                if i not in graph:
                    graph[i] = []
                if M[i][j] and M[j][i]:
                    graph[i].append(j)
                if len(graph[i]) > current:
                    max_i = i
                    current = len(graph[i])

        return graph,max_i
    def findCircleNum(self, M):
        """
        :type M: List[List[int]]
        :rtype: int
        """
        m,n = len(M),len(M[0])
        visited = set()
        count = 0
        graph,start = self.create_graph(len(M),len(M[0]), M)
        queue = [start]
        print(queue)
        while queue:
            i = queue.pop(0)
            if i not in visited:
                visited.add(i)
                count += 1
            for node in graph[i]:
                if node not in visited:
                    queue.append(node)
        return m - count + 1

                # i think its DP
