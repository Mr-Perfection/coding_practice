class Solution(object):

    # did not work...
    def get_start(self, n, prereq):
        courses = set()
        for p in prereq:
            courses.add(p[0])
        if not(courses): return -1
        for i in range(n):
            if i not in courses:
                return i
        return -2
    def findOrder(self, n, prereq):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: List[int]

        assumptions:
            [1,0] means you need to take course0 to take course 1.

        Approach#1: BFS
            get the starting point which is course 0
            queue = [0]
            path = [0]
            visited = set()
            while queue
                course = queue.pop(0)
                if course not in visited
                    visited.add(course)
                for p in prereq
                    if p[1] == course and p[0] not in visited
                        queue.append(p[0])
                        path.append(p[0])

            return path



        """
        start = self.get_start(n, prereq)
        if start == -1: return [i for i in range(n-1,-1,-1)]
        if start == -2: return []
        queue = [start]
        path = [start]
        visited = set()
        while queue:
            course = queue.pop(0)
            if course not in visited:
                visited.add(course)
            for p in prereq:
                if p[1] == course and p[0] not in visited:
                    queue.append(p[0])
                    path.append(p[0])
        return path


    class Solution(object):

    def create_graphs(self, n, prereq):
        courses = {}
        prereqs = {}

        for i in range(n):
            courses[i] = set()
            prereqs[i] = set()

        for i,j in prereq:
            courses[i].add(j)
            prereqs[j].add(i)

        return [courses, prereqs]

    def findOrder(self, n, prereq):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: List[int]
        1:
        2: 1,3
        3: 1

        1: 2,3
        2:
        3: 2

        1 ->
        """
        courses,prereqs = self.create_graphs(n, prereq)
        queue = [i for i in courses if not(courses[i])]
        count, res = 0, []
        while queue:
            c = queue.pop(0)
            res.append(c)
            count += 1
            for i in prereqs[c]:
                courses[i].remove(c)
                if not(courses[i]):
                    queue.append(i)
        return res if count == n else []
