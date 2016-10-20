import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        
        for (int t = 0; t < T; ++t)
        {
            String s1 = in.next();
            String s2 = in.next();
            char str1[] = s1.toCharArray();
            char str2[] = s2.toCharArray();
            boolean ans = false;
            boolean bool_arr[] = new boolean[26];
            int i = 0;
            Arrays.fill(bool_arr, false);
            //set true by storing str1
            for (i = 0; i < str1.length; ++i)
            {
                bool_arr[str1[i] - 'a'] = true;
            }
            
            for (i = 0; i < str2.length; ++i)
            {
                if (bool_arr[str2[i] - 'a'] == true)
                {
                    ans = true;
                    break ;
                }
            }
            if (ans)
                System.out.println("YES");
            else
                System.out.println("NO");
        }   
        
        in.close();
    }
}