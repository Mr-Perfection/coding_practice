import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        //Iterate through the test cases
        for (int t = 0; t < T; ++t)
        {
            int i = 0, j = 1;
            int S = 1, P = 0;
            int n = in.nextInt();
            long HPs[] = new long[n];
            long total_HPs = 0;
            for (i = 0; i < n; ++i)
            {
                //store those mandragoras HPs.
                HPs[i] = in.nextLong();
                total_HPs += HPs[i];
            }
            //sort the array in increasing order.
            Arrays.sort(HPs); //ex. 2 2 3
            long curr_EXP = total_HPs; //because 1 * all HPs = total_HPs ex. 7
            long temp_EXP = 0;
            //keep eating mandragoras and check the EXP points if it is decreasing or not.
            while (j < n)
            {
                S += 1;
                total_HPs -= HPs[j - 1]; 
                temp_EXP = S * (total_HPs);
                //check if curr_EXP is less than the new EXP points with additional S from eating mandragoras.
                if (curr_EXP <= temp_EXP)
                {
                    curr_EXP = temp_EXP; 
                } else //is the EXP points starts to decrease? Then, this ought to be the answer
                {
                    //System.out.println(curr_EXP);
                    break ;                    
                }
                //System.out.println(curr_EXP);
                j++;
            }
            System.out.println(curr_EXP);
            
        }
    }
}