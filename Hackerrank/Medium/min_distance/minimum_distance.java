import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int ft_min(List<Integer> list)
    {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < list.size(); ++i)
        {
            int x = list.get(i);
            if (min > x)
                min = x;
        }
        return (min);
    }
    static void ft_search(int[] arr, boolean[] flags, List<Integer> ans)
    {
        int i = 0;
        int j = arr.length - 1;
        while(i < j)
        {
            //System.out.println("hello");
            
            if (flags[j] == false)
            {
                //arr[i] == arr[j]?
                if (arr[i] == arr[j]) //then decrements j and increments i at the same time (already found a pair)
                {
                    ans.add(Math.abs(i - j));
                    flags[j] = true; //set as already taken.
                    i++;
                    j = arr.length - 1; //reset j
                    continue;
                }
                
                    
            }
            j--;
            
            
        }
            
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int A[] = new int[n];
        boolean flags[] = new boolean[n];
        List<Integer> ans = new ArrayList<Integer>();
        for(int A_i=0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
        }
        /*
            6
            7 1 3 4 1 7
            6 2 6 4 4 2
            1 1 3 4 7 7
            1 1 //skip two times
            3 4 //once
            4 7
            7 7
            
            1 has a pair. (4 - 1)
            7 has a pair. (5 - 0)
            ans: min(4 - 1, 5 - 0) = 3
            
        */
 
        ft_search(A, flags, ans);
        if (ans.isEmpty())
            System.out.println(-1);
        else
            System.out.println(ft_min(ans));
        
    }
}