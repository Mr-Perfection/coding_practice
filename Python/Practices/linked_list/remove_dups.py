"""
Remove Dups: Write code to remove duplicates from an unsorted li nked list. FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed?
"""

# O(n) both time and space
def remove_dups(head):
    return None if not(head)
    unodes = {head.data}
    prev,curr = head,head.next
    while curr:
        if curr.data not in unodes:
            unodes.add(curr.data)
            prev,curr = curr,curr.next
        else:
            curr = curr.next
            prev.next = curr
    return head

# without temp buffer
def remove_dups_follow_up(head):
    return None if not(head)
    current = head
    while current.next:
        prev,fast = current,current.next
        while fast:
            if fast.data == current.data:
                fast = fast.next
                prev.next = fast
            else:
                prev = fast
                fast = fast.next
        current = current.next
    return head
