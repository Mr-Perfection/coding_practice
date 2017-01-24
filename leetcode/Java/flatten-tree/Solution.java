/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 /*
 1 ->
 go left
 1 -> 2
 */

 //WRONG
public class Solution {
    public static TreeNode flatten_tree(TreeNode root)
    {
        if (root.left == null) return (root);
        
        TreeNode node = root;
        
        //if the left node is not null, then go to the left node.
        node = flatten_tree(node.left);
        
        //starting from the leftmost node, insert left node between root node and root right node.
        TreeNode right = root.right;
        root.right = node;
        root.left = null;
        node.right = right;
        return (root);
    }
    public void flatten(TreeNode root) {
        //if root is null, then return 
        if (root == null) return ;
        root = flatten_tree(root);
        
        
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 /*
 1 ->
 go left
 1 -> 2
 */
public class Solution {
    public void flatten(TreeNode root) {
        //if root is null, then return 
        if (root == null) return ;
        
        //initializations
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        
        //iterate until p is null or stack is not empty
        while (p != null || !stack.empty())
        {
            //if p.right exists, push to the stack
            if (p.right != null) stack.push(p.right);
            
            //if p.left exists, set p.right to p.left
            if (p.left != null)
            {
                p.right = p.left;
                p.left = null;
            }
            //or if stack is not empty
            else if (!stack.empty())
            {
                TreeNode temp = stack.pop();
                p.right = temp;
            }
            p = p.right;
            
        }
        
        
    }
}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 /*
 1 ->
 go left
 1 -> 2
 */
public class Solution {
    public void flatten(TreeNode root) {
       
       //check if root exists
       if (root == null) return ;
       
       //use stack to keep track of nodes
       Stack<TreeNode> stack = new Stack<TreeNode>();
       //use pointer to point the node
       TreeNode p = root;
       
       //while stack is not empty
       while (p != null || !stack.empty())
       {
           //if the right node exists, push the right node into the stack
           if (p.right != null) stack.push(p.right);
           
           //if the left node exists, re-assign it to the right node
           if (p.left != null)
           {
               p.right = p.left;
               p.left = null;
           }
           else if (!stack.empty())
           {
               p.right = stack.pop();
           }
           
           
           p = p.right;
       }
    }
}