"""
Check Balanced: Implement a function to check if a binary tree is balanced. For the purposes of this question,
a balanced tree is defined to be a tree such that the heights of the two subtrees of any node never differ by more than one.





my algorithm as below (Wrong):
    preorder_traversal(head)
        1. use modified preorder traversal function that returns max height.
        2. call the function described in 1. recursively to get heights of left tree and right tree of current head.
        3. return abs(height of left tree - height of right tree)
    check_balanced
        1. call preorder_traversal and if it returns > 1, return False. Otherwise, return True
"""
"""

                2
        1           3
    3       4   2       5
                            7

        (2,1)
    (1,1+0)   (3,1+0)
(3,1)=1  (4,1)

X Wrong but if you tweak this... It is O(n) time complexity answer and O(k) k as levels of tree

UPGRADED

                2
        1           3
    3       4   2       5
                            7
                                9
                     SUCCESS! NOT BALANCED
                    x (2, -2)
        x1 (1,1+x2)         (3,2 > 1 so -2)
    x2 (3,1)=1  (4,1)   (2,1-1)  (5,1+1)
x3                                  (7,1+0)
x4                                 -1    0

my algorithm as below (Correct):
    get_height
    1. returns the maximum height of a tree (preorder traversal)
    check_balanced
    1. base case: if head is None, return True
    2. call get_height method for left and right subtrees which will return height of those trees.
    3. check the difference of those two heights and if it is greater than 1 return False else return check_balanced(head.left) and check_balanced(head.right)

    time: O(n log n) best case if balanced tree
    space: O(n)

"""
"""
params: Node, head node
returns int, max height of a tree
"""
def get_height(head):

    if not(head):
        return 0

    return 1 + max(get_height(head.left), get_height(head.right))
def check_balanced(head):

    if not(head):
        return False

    # get height of left subtree
    height_left = get_height(head.left)
    height_right = get_height(head.right)

    #if the difference between heights is > 1, return False
    if abs(height_right - height_left) > 1:
        return False
    else:
        return True


# more time efficient version. Time: O(n), Space: O(k), k is the depth of a tree
import sys

# defined -1 as an error code and 0 as a top level because check_balanced starts from head's subtrees
def get_height(head):

    if not(head):
        return 0

    left_height = get_height(head.left)
    if left_height == -1
        return -1 #pass error up

    right_height = get_height(head.right)
    if right_height == -1
        return -1 # pass error up

    return 1 + max(get_height(head.left), get_height(head.right))

# sIMILAR APPROACH as above... Pass error code as -2
 def preorder_traversal_modified(head):
    # if head is None, no depth assigned
    if not(head):
        return -1
    # get depth of left subtree
    max_depth_left = preorder_traversal_modified(head.left)
    if max_depth_left == -2:
        return -2
    # get depth of right subtree
    max_depth_right = max_depth, preorder_traversal_modified(head.left)
    if max_depth_right == -2:
        return -2
    if abs(max_depth_right - max_depth_left) > 1:
        return -2
    # return absolute value of left and right
    return abs(max_depth_right - max_depth_left) + 1

""" check_balanced
    params: beginning head of tree
    return: 1 or 0

    Time: O(n) for non-balanced tree
    Time: O(log(n)) for non-balanced tree
    Space: O(1)
"""
def check_balanced(head):

    if not(head):
        return False

    if preorder_traversal_modified(head) == -2:
        return False
    else:
        return True
