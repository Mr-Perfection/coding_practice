# Definition for singly-linked list with a random pointer.
# class RandomListNode(object):
#     def __init__(self, x):
#         self.label = x
#         self.next = None
#         self.random = None

class Solution(object):
    def copyRandomList(self, head):
        """
        :type head: RandomListNode
        :rtype: RandomListNode
        """
        """
        what is deep copy?
        Right now, linkedlist is pointing to the 'next' node. the objective is for me to point next as 'random' node
        wrong definition
        a -> b -> c -> d
        c    d    b    None

        Approach #1 time: O(n), space: O(n)
        * ret_head = new Node(head.data)
        * ptr = ret_head
        * node = head.next
        * loop until node is None
            ptr.next = new Node(node.data)
            ptr.random = new Node(node.random)
            ptr = ptr.next
            node = node.next
        * return ret_head

        does not work. and did not understand the question well

        what is deep copy?
        It means create a copy of every node and create a seperate linkedlist

        a -> b -> c -> d
        a -> a' -> b -> b' -> c -> c' -> d -> d'

        """
        if not(head): return None
        ptr = head
        # step1: coping the node to next
        while ptr:
            temp = ptr.next
            ptr.next = RandomListNode(ptr.label)
            ptr.next.next = temp
            ptr  = temp

        #step3: link random node of every other node to ptr's random.next
        copy = head.next
        ptr = head
        while ptr:
            copy = ptr.next
            if ptr.random:
                copy.random = ptr.random.next
            else:
                copy.random = None
            if not(copy.next): break
            ptr = copy.next

        #step2: link next node to every other node (or copied node)
        copy = head.next
        ptr = head
        copy_head = head.next
        while ptr and copy:
            ptr.next = ptr.next.next
            if not(copy.next): break
            copy.next = copy.next.next
            copy = copy.next
            ptr = ptr.next




        return copy_head
        
