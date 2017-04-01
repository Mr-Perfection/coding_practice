# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def get_length(self,head):
        cnt = 0
        while head:
            cnt += 1
            head = head.next
        return cnt
    def partition(self,head, n):
        node = head
        while n > 0:
            n -= 1
            if n == 0:
                node = head.next
                head.next = None
            else:
                head = head.next
        return node

    def reverse(self, head):
        if not(head): return None
        if not(head.next):
            return head

        current = head.next
        head.next = None
        while current:
            temp = current.next
            current.next = head
            head = current
            current = temp
        return head

    def compare_two(self,head,second_head):
        while head and second_head:
            if head.val != second_head.val:
                return False
            head = head.next
            second_head = second_head.next
        return True
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        a->b->b->a  a->b->null, a->b->null then compare two
        a->b->c->b->a a->b->null, a->b->null then compare two
        approach #1 reverse list and compare time:O(n) space:O(n)

        approach #2 reverse list from center to right. iterate from left and from right time:O(n) space:O(1)
        * n = get length of list
        * center node = partition_list(head, n/2)
        * center node = partition_list(head, n/2+1) if n is odd
        * second part = reversed(center node)
        * return compare_two(head, second_part)

        """
        n = self.get_length(head)
        second = self.reverse(self.partition(head,n/2+1) if n % 2 else self.partition(head,n/2))
        return self.compare_two(head, second)
