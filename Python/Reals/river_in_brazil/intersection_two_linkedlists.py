# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def get_length(self,head):

        cnt = 0
        while head:
            head = head.next
            cnt += 1
        return cnt
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        Approach #1 store a list A time: O(n) space: O(n)
        * store nodes from list A to set() and return node if node exists in a set


        Approach #2 get diff in length
        * fast-forward the longer list by diff in lengths of both headA and headB
        * iterate through both nodes at the same speed and find the intersecting node
        """

        lengthA = self.get_length(headA)
        lengthB = self.get_length(headB)

        if not(lengthA) or not(lengthA): return None
        longer = headA if lengthA > lengthB else headB
        shorter = headA if lengthA <= lengthB else headB
        diff = abs(lengthA-lengthB)

        while diff:
            longer = longer.next
            diff -= 1

        while longer and shorter:
            if longer == shorter: return longer
            longer = longer.next
            shorter = shorter.next
        return None


        
