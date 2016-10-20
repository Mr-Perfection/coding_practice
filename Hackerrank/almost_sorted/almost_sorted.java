import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        boolean ans = true;
        int n = in.nextInt();
        int d[] = new int[n];
        //int temp[] = new int[n];
        int i = 0;
        for (i = 0; i < n; ++i)
        {
            d[i] = in.nextInt();
            //temp[i] = d[i];
        }
        
        
        //1 5 4 3 2 6  => d[i] = 2, i = 4...  2 1 => d[i] = 1, i = 1
        //find the first increasing integer from the right <-
        int r_index = -1;
        for(i = n - 1; i > 0; --i)
        {
            if ( d[i - 1] > d[i])
            {
                r_index = i;
                break;
            }
        }
        //System.out.println("right: " + r_index );
        //find the second number that is right before decreasing integer from left 1 5 4 3 2 6  => d[i] = 5, i = 1
        int l_index = -1;

        for (i = 0; i < r_index; ++i)
        {
            if (d[i] > d[i + 1])
            {
                l_index = i;
                break;
            }
        }
        
        //if r_index or l_index is not set or is -1 then "no"
        if (r_index == -1 || l_index == -1)
        {
            System.out.println("no");
            return ;
        }
        
        
        //check if swap can be possible
        int tmp = d[l_index];
        d[l_index] = d[r_index];
        d[r_index] = tmp;
        
        //check if it is sorted or not
        for (i = 0; i < n - 1; ++i)
        {
            if (d[i] > d[i + 1])
            {
                ans = false;
                break ;
            }
        }
        //if ans is still true then it is swap correct
        if (ans)
        {
            l_index += 1;
            r_index += 1;
            System.out.println("yes");
            System.out.println("swap " +l_index + " " + r_index);
            return ;
        }
        else
        {
            int sub_size = r_index - l_index;
            if (n < 3 || sub_size < 2)
            {
                System.out.println("no");
                return ;
            }
            
            //swap back ,try the substring method and continue...
            d[r_index] = d[l_index];
            d[l_index] = tmp;
            ans = true;
        }
        
        
        
        //System.out.println("right: " + r_index + "left: " + l_index);
        int sub_len = r_index - l_index + 1;
        int arr [] = new int[sub_len];
        int j = 0;
        //store the substring into arr from left to right indices
        for (i = r_index; i >= l_index; --i)
        {
            arr[j] = d[i];
            j++;
        }
        j = 0;
        //then put them back into the d array
        for (i = l_index; i <= r_index; ++i)
        {
            d[i] = arr[j];
            j++;
        }
        //check if it is sorted or not
        for (i = 0; i < n - 1; ++i)
        {
            if (d[i] > d[i + 1])
            {
                System.out.println("no");
                return ;
            }
        }
        //its an answer!
        System.out.println("yes");
        l_index += 1;
        r_index += 1;
        System.out.println("reverse" + " " + l_index+ " " + r_index);
        
        
            
    }
}