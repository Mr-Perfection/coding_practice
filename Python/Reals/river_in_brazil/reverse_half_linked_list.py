"""
Design a function that reverses the second half of a singly-linked list

n = 4

   ^
"""
def get_len(head):
    n,node = 0, head

    while node:
        n += 1
        node = node.next
    return n
def reverse_list(head):
    # check if head is None
    if not(head):
        return None
    # assign n
    n,node,first_half = get_len(head),head,head # get the length of a linked-list
    reverse_head = Node(0)
    for i in range(n/2):
        first_half = node
        node = node.next

    first_half.next = None
    reverse_head.next = node
    node = reverse_head.next
    while node.next:
        node = node.next
    node.next = head
