import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner in = new Scanner(System.in);
        //this is a char array from a...z
        
        int T = in.nextInt();
        int t = T;
        
        while (t > 0)
        {
            int count = 0;
            int chars_first[] = new int[26];
            int chars_second[] = new int[26];
            Arrays.fill(chars_first, 0);
            Arrays.fill(chars_second, 0);
            String str = in.next();
            char s[] = str.toCharArray();
            
            //check if it is a odd number string
            if (s.length % 2 != 0)
            {
                System.out.println(-1);
                
            }
            else
            {   
                int i = 0;
                int start_second = s.length / 2;
                //get the first half
                for (i = 0; i < start_second; ++i)
                {
                    chars_first[s[i] - 'a'] += 1;
                    //System.out.print(s[i]);
                    //System.out.print( " " + chars_first[s[i] - 'a']);
                }
                //System.out.println("");
                
                for (i = start_second; i < s.length; ++i)
                {
                    chars_second[s[i] - 'a'] += 1;
                    //System.out.print(s[i]);
                }
                //System.out.println("");
                //store all the differences into count
                for (i = 0; i < chars_second.length; ++i)
                {   
                    if (chars_second[i] > chars_first[i])
                    {
                        //System.out.println("YES");
                        count += (chars_second[i] - chars_first[i]);
                    }
                }
                System.out.println(count);
            }
            
            t--;
        }
    }
}