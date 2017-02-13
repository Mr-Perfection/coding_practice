"""
Check Subtree: T l and T2 are two very large binary trees, with T l much bigger than T2. Create an
algorithm to determine if T2 is a subtree of Tl.
A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n is identical to T2. That is, if you cut off the tree at node n, the two trees would be identical.

T1 T2 are the binary trees
T1 > T2 in size

I assumed that this problem is to check if T2 is literally part of T1

Time: O(n) in worst case n = # of nodes in T1, m = # of nodes in T2
      O(n-m) in best case
Space: Same as time complex.
"""

def preorder_traversal(node1,root2):
    # base case
    if not(node1):
        return False

    # compare the node1 and node2 as references.
    if node1 == root2:
        return True
    # recurse through T1 to find a node that matches with root2 of T2,
    return preorder_traversal(node1.left,root2) or preorder_traversal(node1.right,root2)


def check_subtree(root1,root2):
    # check if either of root exists
    if not(root1) or not(roo2):
        return False
    # if we do not find a matching node, it means T2 is not a subtree of T1
    return preorder_traversal(root1,root2)



"""Other approach. If we are only caring about the identical data from subtree in T1 and T2.
are they BSTs?
If not, there are possible duplicates.
I assumed they are duplicates to make it harder.

Time complex:
O(n*m) n = # of nodes in T2, m = # of nodes in T1 in worst case

O(n) n = # of nodes in T2, m = # of nodes in T1 in best case

Space:
O(n+m) worst case

"""

def modified_preorder(node1,root2,candidates):
    # base case
    if not(node1):
        return False

    # compare the node1 and node2 as data.
    if node1.data == root2.data:
        candidates.append(node1)
    # recurse through T1 to find a node that matches with root2 of T2,
    return preorder_traversal(node1.left,root2) or preorder_traversal(node1.right,root2)

def compare_trees(root1,root2):
    # base case
    if not(root1) and not(root2):
        return True
    # compare the data of root1 and root2
    if root1.data != root2.data:
        return False
    # pre-order traversal
    return compare_trees(root1.left,root2.left) and compare_trees(root2.right,root2.right)

def check_subtree(root1,root2):
    # check if either of root exists
    if not(root1) or not(root2):
        return False
    # candidates for the starting nodes
    candidates = []
    # get the starting nodes that has a same value
    modified_preorder(root1,root2,candidates)

    # iterate through the candidates to check if this node is identical subtree as T2
    for c in candidates:
        if compare_trees(c,root2):
            return True
    return False
