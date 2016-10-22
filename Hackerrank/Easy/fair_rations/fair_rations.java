import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    //test cases:
    /*
    
        1:
        2 3 4 5 6
        2 4 5 5 6
        2 4 6 6 6
        2:
        2 3 4 5 7 #0
        2 4 5 5 7 #2
        2 4 6 6 7 #4
        2 4 6 7 8 #6
        2 4 7 8 8 
    */
    /*using recursive approach*/
    //public static int  count = 0;
    // static boolean ft_make_even(int arr[], int n, int i)
    // {
    //     //base case
    //     //System.out.println("count : " + count);
    //     if (i == n) // n = 6
    //         return (true);
    //     //need to try to make it even
    //     if (arr[i] % 2 != 0)
    //     {
    //         //if i is not the last element
    //         if(i < n)
    //         {
    //             arr[i] += 1;
    //             arr[i + 1] += 1;
    //             Solution.count += 2;
    //             return (ft_make_even(arr, n, i + 1));
    //         }    
    //         else
    //             return (false);
            
            
    //     }    
    //     else
    //         return (ft_make_even(arr, n, i + 1));
        

    // }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int B[] = new int[N];
        int count = 0;
        for(int B_i=0; B_i < N; B_i++){
            B[B_i] = in.nextInt();
            
        }
        //first check if N  < 3
        if (N < 3)
        {
            System.out.println("NO");
            return ;
        }
        for(int i = 0; i < N - 1; ++i)
        {
            // if it is not even
            if (B[i] % 2 != 0)
            {               
                B[i] += 1;
                B[i + 1] += 1;
                count += 2;
            }    
            //if i is the N - 2
            if (i == N - 2)
            {
                if (B[i] % 2 != 0 || B[i + 1] % 2 != 0)
                {
                    System.out.println("NO");
                    return ;
                }
            }
        } //EOF for
        System.out.println(count);

        // if (ft_make_even( B, N, 0))
        //     System.out.println(Solution.count);
        // else
        //     System.out.println("NO");

        
        /*
            5
            2 3 4 5 6
        */
        
    }
}
