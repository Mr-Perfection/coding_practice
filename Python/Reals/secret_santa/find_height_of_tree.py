'''
given a binary tree, find its height

        4
    2       5
      3  6        n = 2

input: top node
output: 2
inorder traversal
3->2->4

this returns count
traversal(head)
    if head == None
        return 0
    return 1 + max(traveral(head.left),traversal(head.right)

'''

def traverse(head):
    if head == None:
        return -1
    return 1 + max(traverse(head.left),traverse(head.right))
