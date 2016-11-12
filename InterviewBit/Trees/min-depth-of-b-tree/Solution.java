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

    
	public int minDepth(TreeNode a) {
	    
	    if (a == null)
	        return (0);
	   // if (a.left == null || a.right == null)
	   //     return (1);
	    //recursively call the left node of current node
	    int left = minDepth(a.left);
	    int right = minDepth(a.right);
	    //if left node is null then just add right + 1
	    if (a.left == null)
	        return (right + 1);
	    else if (a.right == null)
	        return (left + 1);
	    
	    //left is 0, then you need to increment 
	    return (Math.min(left, right) + 1);
	}
}
