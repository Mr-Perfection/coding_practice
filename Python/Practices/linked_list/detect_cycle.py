"""
Detect a cycle in a linked list. Note that the head pointer may be 'None' if the list is empty.

A Node is defined as:

    class Node(object):
        def __init__(self, data = None, next_node = None):
            self.data = data
            self.next = next_node
"""


def has_cycle(head):
    slow,fast = head,head
    if not(slow):
        return False
    while fast.next and fast.next.next:
        slow = slow.next
        fast = fast.next.next
        if slow.data == fast.data:
            return True
    return False
