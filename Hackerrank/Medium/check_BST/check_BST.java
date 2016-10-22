/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/
    //we will be storing the temp. node to see if prev node is less than right node.
    Node prev;
    boolean checkBST(Node root) {
        //if root is null return true
        if (root == null)
            return (true);
        
        //using in order traversal to check BST
        //is left node is null??
        if (!checkBST(root.left))
        {
            return (false);
        }

        //if there stored previous node and prev.data is GREATER than root.data then return FALSE
        if (prev != null && prev.data >= root.data)
        {
            return (false);
        }
        //store the current root node
        prev = root;
        //go to the right node...
        return (checkBST(root.right));
            
        
        
    }
