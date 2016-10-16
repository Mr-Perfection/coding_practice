import java.io.*;
import java.util.*;

public class Solution {
    //https://www.hackerrank.com/challenges/save-the-prisoner
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        
        long t = 0;
        //# of test cases
        long T = in.nextInt();
        
        for (t = 0; t < T; ++t)
        {
            //# of prisoners 6 
            long N = in.nextLong();
            //# of sweets (last one is poisoned) 3
            long M = in.nextLong();
            //ID number of the starting prisoner 2
            long S = in.nextLong();
            
            //here you need to check the overflow (whether S + M - 1 exeeds total number of prsioners, N)
            if (S + M - 1 > N)
            {
                
                long overflow = (S + M - 1) - N;
                if (overflow > N)
                {
                    while(overflow > N)
                        overflow -= N;
                }
                System.out.println(overflow);
            }
            else
                System.out.println(S + M - 1);
            
        
        }
        
        
        
        in.close();
    }
}