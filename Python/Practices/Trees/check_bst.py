'''
given a binary tree, check if it is BST or not

        6
    3      8
1     4  5   9

return True or False
traverse(head,ancestor)
    if head == None
        return False
    if not(head.right) and head.left:
        return traverse(head.right)
    if not(head.left) and head.right:
        return traverse(head.left)
    if head.left.data >= head.data and head.right.data <= head.data
        return False
    if head.left.data < head.data and head.right.data > head.data
        if ancestor and ancestor.data < head.left.data and ancestor.data > head.r
            return traverse(head.left,head) and traverse(head.right,head)

'''
