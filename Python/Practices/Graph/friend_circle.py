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
