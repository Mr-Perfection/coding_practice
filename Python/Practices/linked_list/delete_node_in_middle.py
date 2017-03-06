"""
Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but the first and last node, not necessarily the exact middle) of a singly linked list, given only access to that node.
EXAMPLE
Input: the node c from the linked list a - >b- >c - >d - >e- >f
Result: nothing is returned, but the new linked list looks like a - >b- >d - >e- >f
"""
def delete_middle(node):
    if not(node) or not(node.next):
        return False
    next_node = node.next
    node.data = next_node.data
    node.next = next_node.next
    return True
