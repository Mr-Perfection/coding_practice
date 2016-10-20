import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/*
Question on Hackerrank:
https://www.hackerrank.com/challenges/ctci-recursive-staircase

*/
public class Solution {

    //using recursive top down approach
    //n = 3 1 + 1 + 1 + 1
    //implementing the cache to store the calculated values time comp. = 3n = O(n)
    static int ft_count_stairs(int n, HashMap<Integer, Integer> cache)
    {
        //base case when there are no more stairs left
        //System.out.println("n is: " + n);
        if (n == 0)
            return (1);
        else if ( n < 0)
            return (0);
        //does this cache already have a value?
        if (cache.containsKey(n))
            return (cache.get(n));
        cache.put(n, ft_count_stairs(n - 1,cache) + ft_count_stairs(n - 2, cache) + ft_count_stairs(n - 3, cache));
        return (cache.get(n));
    }
    
    //bottom up approach (traditional DP way), time-comp. = O(n), more efficient than using stack (top down).
    /*
        DISCLAIMER: make sure you draw the solution array to follow what i'm doing right now...
        
        So first I tried to implement using 2D array but then I realized... nah, I can do it with 1D.
        Basically, the logic was really simple...
        You get the # of stairs and # of steps from 1, 2, 3.
        I store them into solution[] first.
        Then I iterate until n and set sol = sol(i - 1) + sol(i - 2) + sol(i - 3)
    */
    static int ft_count_stairs(int n)
    {
        if (n < 3)
            return (n);
        int solution[] = new int[n + 1];
        int i = 0;
        solution[0] = 0;
        solution[1] = 1;
        solution[2] = 2;
        solution[3] = 4;
        //first set zero to the first column because there are no ways if n (or stairs) is equal to 0.
        for (i = 4; i <= n; ++i)
        {
            // add i - 1 and i -2 th elements and set to solution[i]
            solution[i] = solution[i - 1] + solution[i - 2] + solution[i - 3];
        }
        return (solution[n]);
        
        
        //Previous attempt...
        //then set 1 for first row except when columns = 0 because if step = 1, there is only one possible way except           columns = 0 as i said before.
        /*for (i = 1; i < columns; ++i)
        {
            solution[0][i] = 1;
        }
        then DP approach:
            sol = sol[i + 1][j] + sol[i][j - i]
        
        for (i = 1; i < rows; ++i)
        {
            for (j = 1; j < columns; ++j)
            {
                if ((j >= i))
                    solution[i][j] = solution[i - 1][j] + solution[i][j - i];
                else
                    //if the step is greater than the num. of stairs then, we just take the value from the previous                         rows (or step #)
                    solution[i][j] = solution[i - 1][j];
            }
        }
        return (solution[rows - 1][columns - 1]);
        */
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        HashMap <Integer, Integer> cache = new HashMap<Integer, Integer>();
        for(int a0 = 0; a0 < s; a0++){
            int n = in.nextInt();
            System.out.println(ft_count_stairs( n));
        }
    }
}
