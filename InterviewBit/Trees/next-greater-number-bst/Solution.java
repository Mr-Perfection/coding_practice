/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {

	public static TreeNode min_node(TreeNode node)
	{
		if (node == null)
			return null;
		while (node.left != null)
			node = node.left;
		return (node);
	}
	public TreeNode getSuccessor(TreeNode a, int b) {
	    
	    //case 1: if b is less than a.val then iterate through the left nodes.
	    if (b >= a.val)
	    	return (min_node(a.right));

	    TreeNode ancestor = null;
	    TreeNode node = a.left;
	    while (node != null)
	    {
	    	//node's value is less than b
	    	if (node.val <= b)
	    	{
	    		ancestor = node;
	    		node = node.right;
	    	}
	    	else
	    	{
	    		ancestor = node;
	    		node = node.left;
	    	}	


	    }
	    return ancestor;
	    // if (b < a.val)
	    // {
	    // 	TreeNode ancestor = a;
	    // 	while (ancestor.left != null && ancestor.left.val > b)
	    // 		ancestor = ancestor.left;
	    // 	return (ancestor);
	    // }
	    // //case 2: if b is greater or equal to a.val then iterate through the right nodes.
	    // else
	    // {
	    // 	TreeNode ancestor = a;
	    // 	while (ancestor.right != null && ancestor.right.val <= b)
	    // 		ancestor = ancestor.right;
	    // 	if (ancestor.right == null)
	    // 		return (null);
	    // 	else
	    // 		return (ancestor);
	    // }

	}
}
