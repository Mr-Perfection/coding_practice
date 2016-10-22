import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Node {
    Map<Character, Node> children;
    char c;
    boolean word; //is complete word?
    int wcount; //this will count the all the words associated to this letter.
    public Node()
    {
        this.c = 0;
        this.wcount = 0;
        this.word = false;
        this.children = new HashMap<Character, Node>();
    }
    
    public void add(String s)
    {
        //base case
        if (s.isEmpty())
        {
            //dont wcount + 1 because it is end of the string
            //if string is empty then it is a complete word
            this.word = true;
            return ;
        }
       // System.out.println(this.wcount);
        //count words
        char letter = s.charAt(0);
        //check if the children does not contain this letter
        if (!this.children.containsKey(letter))
        {
            //System.out.println("does not contain key");
            this.children.put(letter, new Node());
        }
        //System.out.println("letter is : "+ letter + " " + this.children.get(letter).wcount);
        this.children.get(letter).wcount+= 1;
        this.children.get(letter).add(s.substring(1));
    }
    
    
    
    
    public boolean isWord(String s)
    {
        //if it reaches the end of the string
        if (s.isEmpty())
            return (this.word);
        
        char letter = s.charAt(0);
        
        //check if the children does not have this letter...if this is true, return false
        if (!children.containsKey(letter))
        {
            return (false);
        }
        return (this.children.get(letter).isWord(s.substring(1)));
    }
    
    public int wordCount(String s)
    {
        
        if (s.isEmpty())
            return (0);
        Node curr = this;
        //System.out.println("word count: " + curr.wcount );
        //iterate before s ends
        for (int i = 0; i < s.length(); ++i)
        {
            if (!curr.children.containsKey(s.charAt(i)))
                return (0);
            
            //it is not a word yet
            if (!curr.children.get(s.charAt(i)).word)
            {
                curr = curr.children.get(s.charAt(i));
            }
            else //it is a word already?
            {
                //System.out.println("hey " + curr.children.get(s.charAt(i)).wcount);
                
                //ONLY if it is end of the string, we will display word count.
                //because there can be multiple words formed in the string
                if (i == s.length() - 1)
                    return (curr.children.get(s.charAt(i)).wcount);
                else //else set the current node
                    curr = curr.children.get(s.charAt(i));
                    
            }
        }
        //count word
        return (curr.wcount);
    }
}

public class Solution {

    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Node root = new Node();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            //add to the tries
            if (op.equals("add"))
            {
                root.add(contact);
            }
            else if (op.equals("find"))
            {
                //find the string in trie
                System.out.println(root.wordCount(contact));
            }
        }
        in.close();
    }
}