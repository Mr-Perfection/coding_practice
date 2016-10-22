import java.io.*;
import java.util.*;

public class Solution {

    static int ft_find_contiguous_max(int max_so_far, int current_max, int[] arr)
    {
        for (int i = 0; i < arr.length; ++i)
        {
            max_so_far = Math.max(max_so_far + arr[i], 0);
            current_max = Math.max(max_so_far, current_max);
        }
        return (current_max);
    }
    static int ft_find_incontiguous_max(int[] arr)
    {
        int max = 0;
        for (int i = 0; i < arr.length; ++i)
        {
            if (arr[i] > 0)
                max += arr[i];
        }
        return (max);
    }
    static int ft_find_max_int(int[] arr)
    {
        int i = 0;
        int max = arr[i];
        for (i = 1; i < arr.length; ++i)
        {
            if(max < arr[i])
                max = arr[i];
        }
        return (max);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 0; t < T; ++t)
        {
            int n = in.nextInt();
            int i = 0;
            int arr[] = new int[n];
            for (i = 0; i < n; ++i)
            {
                arr[i] = in.nextInt();
            }
            //2 -1 2 3 4 -5
            // 2 - 1 = 1, max (0, 1) = 1, max ( 1 + 2, 1) = 3,...
            /*
            my approach:
                function (int max_so_far, int current_max, int[] arr)
                    for i = 0, i < arr.length, ++i
                        max_so_far = max(0, max_so_far + arr[i])
                        current_max = max(current_max, max_so_far)
                    end
                    return current_max
                end
            */
            int max_continguous = ft_find_contiguous_max(0, 0, arr);
            int max_incontinguous = ft_find_incontiguous_max(arr);
            
            if (max_continguous == 0 && max_incontinguous == 0)
            {
                int max = ft_find_max_int(arr);
                System.out.println(max + " " + max);
            }
            else
                System.out.println(ft_find_contiguous_max(0, 0, arr) + " " + ft_find_incontiguous_max(arr));
        }
    }
}