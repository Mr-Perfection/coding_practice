/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


/*

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node’s key.
The right subtree of a node contains only nodes with keys greater than the node’s key.
Both the left and right subtrees must also be binary search trees.
Example :

Input : 
   1
  /  \
 2    3

Output : 0 or False


Input : 
  2
 / \
1   3

Output : 1 or True 
Return 0 / 1 ( 0 for false, 1 for true ) for this problem


*/



public class Solution {

	//check if the left subtree is less than current node
	public static boolean subtree_is_less(TreeNode node, int val)
	{
		if (node == null)
			return (true);
		if (node.val <= val 
		&& subtree_is_less(node.left, val) 
		&& subtree_is_less(node.right, val)) 
		{
			return (true);
		}
		else	
			return (false);
	}
	//check if the right subtree is greater than current node
	public static boolean subtree_is_greater(TreeNode node, int val)
	{
		if (node == null)
			return (true);
		if (node.val > val 
		&& subtree_is_greater(node.right, val) 
		&& subtree_is_greater(node.left, val)) 
		{
			return (true);
		}
		else	
			return (false);
	}
	public int isValidBST(TreeNode a) {
	    //base case return 1 if it is the end of the tree
	    if (a == null) {
	    	return (1);
	    }
	    //return 0 if left tree has of current node has a greater than the current node OR right tree has a lesser or equal value than the current node.
	    if (subtree_is_less(a.left, a.val) 
	    && subtree_is_greater(a.right, a.val)
	    && (isValidBST(a.left) == 1) 
	    && (isValidBST(a.right) == 1)) {
	    	return (1);
	    }
	    else
	    	return (0);
	}
}



public class Solution {
	//Iterative Approach
	public int isValidBST(TreeNode a) {
		if (a == null)
			return (1);
		Stack<Integer> stack = new Stack<Integer>();
		TreeNode root = a;
		int prev = Integer.MIN_VALUE;
		int current;
		while (true)
		{
			//if root is not null then go to left
			if (root != null) {
				stack.push(root);
				root = root.left;
			}
			else
			{
				//stack is empty? then break the loop.
				if (stack.isEmpty())
					break;
				root = stack.pop();
				current = root.val;
				if (current < prev)
					return (0);
				prev = current;
				root = root.right;
			}
		}
		return (1);
	}
}
