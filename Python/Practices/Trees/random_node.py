"""

Random Node: You are implementing a binary tree class from scratch which, in addition to insert, find, and delete, has a method getRandomNode() which returns a random node from the tree. All nodes should be equally likely to be chosen. Design and implement an algorithm for getRandomNode, and explain how you would implement the rest of the methods


Meh
Time: O(1)
"""

class Node:
    def __init__(self,data):
        self.data = data
    # do something
class Tree:
    def __init__(self,head):
        self.head = head
        self.size = 0
        self.nodes = []

    # do something

    def getRandomNode(self):
        if self.size == 0:
            return None
        index = randint(0,self.size)
        return nodes[index]




from random import *

print(randint(9,12))
