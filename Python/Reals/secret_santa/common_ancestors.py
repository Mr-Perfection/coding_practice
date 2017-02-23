'''given head of a tree, and two nodes in the subtree, find the common ancestor of the two nodes'''

Node:
    self.value
    self.left
    self.right
'''
given: head, left, right
        4,    3,    10

            4
        3       10
    5    6    7    8

            4
        3       10
    5    6    7    8



'''

def check_left_node(head,left,ancestors):
    #base case: check is head is None, return False
    if head == None:
        return False
    # post order traversal
    # recurse left,
    if check_left_node(head.left, left,ancestors):
        # if True,
        # store node into ancestors
        ancestors.append(head)
        return True
    # recurse right,
    if check_left_node(head.right, left,ancestors):
        # if True,
        # store node into ancestors
        ancestors.append(head)
        return True

    # if compare references of head and left
    if head == left:
        # if matched, return True
        return True

def find_common_ancestor(head,left,right):
    # check if head,left,right exits
    if not(head) or not(head.left) or not(head.right):
        return
    # initializations
    ancestors = []
    # post order traversal to find the first
    
