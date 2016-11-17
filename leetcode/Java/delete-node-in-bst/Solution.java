/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public static TreeNode findMin(TreeNode root)
    {
        while (root.left != null)
            root = root.left;
        return (root);
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        /*
            since the b-tree is BST, I assume that the tree is ordered.
            
            if root.val < key, 
                then root.next = deleteNode( right node )
                then return root
            if root.val > key, 
                then root.next = deleteNode( left node )
                then return root
            if root.val == key, 
                if root.left != null
                    right = root.right
                    root = root.left
                    root.right = right
                else if root.right != null
                    left = root.left
                    root = root.right
                    root.left = left
        
        */
        if (root == null)
            return root;
        //if root.val is less than the key value, should be on the right tree
        if (root.val < key)
        {
            root.right = deleteNode(root.right, key);
            //return (root);
        }
        //if root.val is greater than the key value then should be on the left tree
        else if (root.val > key)
        {
            root.left = deleteNode(root.left, key);
            
        }
        else 
        {
            //case 1: no child
            if (root.left == null && root.right == null)
                root = null;
            //case 2: one child, left is null
            else if (root.left == null)
            {
                TreeNode temp = root;
                root = root.right;
                temp = null;
            }
            //case 2: one child, right is null
            else if (root.right == null)
            {
                TreeNode temp = root;
                root = root.left;
                temp = null;
            }
            //case 3: two children
            else
            {
                TreeNode temp = findMin(root.right);
                root.val = temp.val;
                root.right = deleteNode(root.right, temp.val);
            }
        }
        return (root);
    }
}