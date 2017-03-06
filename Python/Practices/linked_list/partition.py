"""
Partition: Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x.
lf x is contained within the list, the values of x only need to be after the elements less than x (see below).
The partition element x can appear anywhere in the "right partition";
it does not need to appear between the left and right partitions.

"""
def partition(head,value):
    # create temp nodes
    part1_head,part2_head = Node(0),Node(0)
    part2_tail = part2_head
    part1_tail = part1_head

    # iterate through the linked-list
    while head:
        temp = head.next
        # if head data is less than value, add to part1_tail
        if head.data < value:
            part1_tail.next = head
            head.next = None
            part1_tail = part1_tail.next
        else:
            part2_tail.next = head
            head.next = None
            part2_tail = part2_tail.next
        head = temp
    part1_tail.next = part2_head.next
    return part1_head.next
