import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int i;
        char peek;
        Stack<Character> stack = new Stack<Character>();
        for(int a0 = 0; a0 < t; a0++)
        {
            boolean ans = true;
            stack.clear();
            String s = in.next();
            for(i = 0; i < s.length(); ++i)
            {
                char c = s.charAt(i);
                if (c == '{' || c == '(' || c == '[')
                    stack.push(c);
                if (c == '}')
                {
                    //if stack is empty, then NO
                    if(stack.empty())
                    {
                        ans = false;
                       // System.out.println("NO");
                        break ;
                    }   
                    
                    peek = stack.peek().charValue();
                    //if peeked value at the stack is '{' then pop
                    if(peek == '{')
                        stack.pop();
                    else
                    {
                        ans = false;
                        //System.out.println("NO");
                        break ;
                    }   
                }
                else if (c == ')')
                {
                    if(stack.empty())
                    {
                        ans = false;
                        //System.out.println("NO");
                        break ;
                    }   
                    peek = stack.peek().charValue();
                    if(peek == '(')
                        stack.pop();
                    else
                    {
                        ans = false;
                        //System.out.println("NO");
                        break ;
                    }   
                        
                }
                else if (c == ']')
                {
                    if(stack.empty())
                    {
                        ans = false;
                        //System.out.println("NO");
                        break ;
                    }   
                    peek = stack.peek().charValue();
                    if(peek == '[')
                        stack.pop();
                    else
                    {
                        ans = false;
                        //System.out.println("NO");
                        break ;
                    }   
                        
                }
                    
            }
            //if stack is not empty and 
            if(stack.empty() == true && ans)
                System.out.println("YES");
            else 
                System.out.println("NO");
            
        }
    }
}
