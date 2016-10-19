/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/
    // To keep tract of previous node in Inorder Traversal
    Node prev;
    boolean checkBST(Node root) {
        
        // traverse the tree in inorder fashion and
        // keep a track of previous node
        if (root != null)
        {
            if (!checkBST(root.left))
                return false;
 
            // allows only distinct values node
            if (prev != null && root.data <= prev.data )
                return false;
            prev = root;
            return checkBST(root.right);
        }
        return true;
        
    }
