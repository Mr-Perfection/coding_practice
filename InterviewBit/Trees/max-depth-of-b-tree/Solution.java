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
	public int maxDepth(TreeNode a) {
	    
	    if (a == null)
	        return (0);
	    int left = maxDepth(a.left);
	    int right = maxDepth(a.right);
	    
	    //if left does not have any depth, then return right + 1
	    if (left == 0)
	        return (1 + right);
        //if right does not have any depth, then return left + 1
	    if (right == 0)
	        return (1 + left);
	    //right and left have values then get the maximium value among them + 1
	    return (1 + Math.max(right, left));
	}
}
