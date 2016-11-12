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

	public int lca(TreeNode a, int val1, int val2) {

	    if (a == null)
	        return (-1);
	    //in order traversal
	    // If either n1 or n2 matches with root's key, report
		// the presence by returning root (Note that if a key is
		// ancestor of other, then the ancestor key becomes LCA
		if (a.val == val1 || a.val == val2)
			return a.val;
		// look for keys in left and right subtrees
		int left = lca(a.left, val1, val2);
		int right = lca(a.right, val1, val2);
		// If both of the above calls return Non-NULL, then one key
		// is present in once subtree and other is present in other,
		// So this node is the LCA
		if (left != -1 && right != -1)
		 	return a.val;
		 // ptherwise check if left subtree or right subtree is LCA
		 return (left != -1) ? left : right;
	}
}

public class Solution {
    
    Boolean flag1, flag2;
	public int lca(TreeNode a, int val1, int val2) {
	   //case 1: a is null
		if (a == null)
			return (-1);
		flag1 = flag2 = false;
		//case 2: left node and right node of root node a are null.
		if (a.left == null && a.right == null )
			return (-1);
		//case 3: find the ancestor node that has both val1 and val2.
		TreeNode ancestor = find_lca(a, val1, val2);

		//if flag1 and flag2 are true, return value of ancestor
		if (flag1 == true && flag2 == true)
			return (ancestor.val);
		else
			return (-1);

	}
	
	public static TreeNode find_lca(TreeNode a, int val1, int val2)
	{
		TreeNode lca = null;
		//case 1: a is null
		if (a == null) 
			return (null);
		//case 2: check if a.val is equal to val1, then set first flag to 1.
		if (a.val == val1) {
			this.flag1 = true;
			lca = node;
		}
		if (a.val == val2) {
			this.flag2 = true;
			lca = node;
		}
		//get the left onde and right node
		TreeNode l = find_lca(a.left, val1, val2);
		TreeNode r = find_lca(a.right, val1, val2);
		if((l != null && r!=null) || (lca != null)) return node;
		return ((l != null) ? l : r);

	}
}

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
    Boolean flag1,flag2;
    
	public int lca(TreeNode a, int val1, int val2) {
	    
	    flag1 = flag2 = false;
	    if(a==null) return -1;
	    if(a.left == null && a.right == null)
	        return (a.val == val1 && val1 == val2) ? a.val : -1;
	    TreeNode temp = find_lca(a,val1,val2);
	    if(flag1 && flag2) 
	        return temp.val;
	    else 
	        return -1;
	}
	
	public TreeNode find_lca(TreeNode node,int val1,int val2)
	{
	    TreeNode lca=null;
	    if(node == null) return null;
	    
	    if(node.val == val1) 
	    {
	        this.flag1 = true;
	        lca = node;
	        //return node;
	    }
	    if(node.val == val2)
	    {
	        this.flag2 = true;
	        lca = node;
	      //  return node;
	    }
	    
	    TreeNode l = find_lca(node.left,val1,val2);
	    TreeNode r = find_lca(node.right,val1,val2);
	    
	    if((l != null && r!=null) || (lca != null)) return node;
	    
	  return l!=null ? l:r;
	}
}
