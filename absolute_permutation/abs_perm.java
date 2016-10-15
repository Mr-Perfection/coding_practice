import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {    
    /*https://www.hackerrank.com/challenges/absolute-permutation**/
    
    /*
    Sample inputs:
    3
    2 1
    3 0
    3 2
    
    4 
    
    Sample outputs:
    2 1
    1 2 3
    -1
    
 
    
   
    
    */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int arr[];
        int perm[];
        int i = 0;
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int diff = in.nextInt();
            boolean isCorrect = true;
            arr = new int[n];
            perm = new int[n];
            
            // if diff = 0, then just print the arr[] as it is.
            if (diff == 0)
            {
                for (i = 1; i <= n; ++i)
                    System.out.print(i + " ");
                System.out.print("\n");
                continue ;
            }
            
            //store 1..n values into arr array
            for(i = 0; i < n; ++i)
            {
                arr[i] = i + 1;
                perm[i] = 0;
            }    
            //use method 1
            for (i = 0; i < n; ++i)
            {
                //System.out.println("test: " + perm[i] + " " + arr[i]);
                
                
                /*here is the logic:
                    arr[] contains [1, 2]
                    perm[] is initially [0, 0]
                    diff = 1
                    if arr[0] + 1 <= 2 && 1 == abs( arr[0+1] - 1) && perm[0] == 0
                    (if    2 <= 2 && 1 == abs( 2 - 1) && 0 == 0 => true)
                        perm[0] = arr[0 + 1]#Swap the two values
                        perm[0 + 1] = arr[0]
                    else
                        if perm[i] == 0 #is still initial 0.
                            flag = false
                            break;
                */
                
                
                
                if (arr[i] + diff <= n && arr[i] == Math.abs(arr[i + diff] - diff) && perm[i] == 0 )
                {    
                    perm[i] = arr[i + diff];
                    perm[i + diff] = arr[i];
                }
                else    
                {
                    if (perm[i] == 0)
                    {
                        isCorrect = false;   
                        break ;
                    }
                }
            }
            
            if (isCorrect)
            {
                for (i = 0; i < n; ++i)
                {
                    System.out.print(perm[i] + " ");
                }
                System.out.println("");
                
            }
            else
                System.out.println(-1);
        }
        
        
        
    }
}
