# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def removeElements(self, head, val):
        """
        :type head: ListNode
        :type val: int
        :rtype: ListNode
        """
        while head and head.val == val:
            head = head.next

        if not(head): return None

        curr = head.next
        prev = head
        while curr:
            if curr.val == val:
                temp = curr.next
                prev.next = temp
                curr = temp
            else:
                prev = curr
                curr = curr.next
        return head


        
