import sys

class MinStack(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.__stack = []
        self.MIN = sys.maxint

    def push(self, x):
        """
        :type x: int
        :rtype: void
        """
        self.__stack.append(x)
        self.MIN = min([self.MIN,x])
    def pop(self):
        """
        :rtype: void
        """
        x = self.__stack.pop()
        if self.__stack:
            self.MIN = min(self.__stack)
        else: self.MIN = sys.maxint

    def top(self):
        """
        :rtype: int
        """
        return self.__stack[len(self.__stack)-1]

    def getMin(self):
        """
        :rtype: int
        """
        return self.MIN


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
