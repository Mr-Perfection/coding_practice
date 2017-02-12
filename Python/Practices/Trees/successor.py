"""

I misunderstood the question

Successor: Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a
binary search tree. You may assume that each node has a link to its parent.

                5
        3               8
    2       4       6       9
My algorithm:

test cases:
find_next(5,4) //returns 4
find_next(5,7) //returns 8
find_next(5,6) // returns 8
(5,6) =>
        (8,6) =>
                return 8
find_next(5,5)
(5,5) =>
        (3,5) => 5
"""

def find_next_node(head,node):
    # base case: check if head is none
    if not(head):
        return None
    # check if head data is greater than node data
    if head.data >= node.data:
        # check if head parent data is less than node data
        if head.parent and head.parent.data < node.data:
            return head
        return find_next_node(head.left, node)
    # check if head data is less than node data
    if head.data < node.data:
        next_node = find_next_node(head.right, node)
    # recurse to the left.


def find_next(head,node):
    # check if head node
    if not(head):
        return None
    return find_next_node(head,node)


"""
Successor: Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a
binary search tree. You may assume that each node has a link to its parent.

objective:
Find a next node that is the least greatest but greater than node.
"""
# find the right tree of parents. Return None if there are no right trees
def find_right_tree(node):
    while node.parent and node.parent.left != node:
        node = node.parent
    return node.parent


def find_left_most_node(node):
    # 2) iterate through the right or right node until it is empty
    while node.right:
        node = node.right
    return node.left

def successor(node):

    if not(node):
        return None
    # 1) check whether right tree exists
    if node.right:
        # 3) return left most node of R
        return find_left_most_node(node)
    # check if node has a parent
    if not(node.parent):
        return None
    # 4) if there is no right tree, move up the level or to the parent and check if there if right node exists
    return find_right_tree(node)
