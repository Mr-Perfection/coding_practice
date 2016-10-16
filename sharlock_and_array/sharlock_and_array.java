import java.io.*;
import java.util.*;

public class Solution {

    //checks left and right based on the middle index
    static boolean ft_is_even(int mid, int N, int[] arr, int right)
    {
        
        int left = 0;

        int i = 0;
        left = arr[mid - 1];
        arr[mid] = arr[mid] + left;
        right = right - arr[mid];
         
        if (left == right)
            return true;
        else
            return false;
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 0; t < T; ++t)
        {
            boolean ans = false;
            int N = in.nextInt();
            int arr[] = new int[N];
            int i = 0;
            for (i = 0; i < N; ++i)
            {
                arr[i] = in.nextInt();
            }
            
            
               
            //get add all the elements
            int right = 0;
            i = N - 1;
            while (i >= 0)
            {
                right += arr[i];
                i--;
            }
            if (N == 1)
            {
                ans = true;
            }
            else if (N < 3)
            {
                ans = false;
            }
            else
            {
                for (i = 1; i < N - 1; ++i)
                {
                  //if this is true then the answer is true
                  if (ft_is_even(i, N, arr, right))
                  {
                      ans = true;
                      break;
                  }
                }
            }
            if (ans)
                System.out.println("YES");
            else
                System.out.println("NO");
        } //EOF for
        in.close();
    }
}