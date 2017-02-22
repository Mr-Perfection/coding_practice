"""
Make a min height balanced tree from a sorted array
"""

def create_tree(arr,left,right):
    # post traversal
    # base case: if left becomes right
    if left >= right:
        return None
    middle = (left + right) / 2
    node = Node(arr[middle])
    node.left = create_tree(arr,left,middle)
    node.right = create_tree(arr,middle+1,right)
    return node



def min_height_balanced_tree(arr):
    return create_tree(arr,0,len(arr))

arr = [1,2,3,4,5,6,7,8]

"""
post order traversal with binary search
get the mid.
make node of mid.
set left to left subtree
set right to right subtree
return mid node.

            5
        3       7
    2       4
1


"""
