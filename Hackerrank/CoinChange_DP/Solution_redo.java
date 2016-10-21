import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
//https://www.hackerrank.com/challenges/ctci-coin-change
public class Solution {

    //First come up with the recursive problem (top down approach)
    static int ft_count_recursive(int i, int coins[], int n)
    {
        /*
            base cases:
                if n becomes a negative number, return 0.
                if n is equal to 0, then count + 1.
                if i (indicates the value of a coin) reaches the end of array, return 0
        */
        if (n < 0) 
            return (0);
        else if (n == 0)
            return (1);
        //if i has reached the end of coins array and the total dollar amount is still greater than 0.
        if (i == coins.length && n > 0)
            return (0);
        return (ft_count_recursive(i + 1, coins, n) + ft_count_recursive(i, coins, n - coins[i]));
    }
    //previous approach is very expensive in time efficiency... 2^(n^2)
    //can reduce it to n^2 by using cache or memoization
    /*
        Memoization:
            In this method, we will be caching the n, the money.
    */
    static int ft_count_cache(int i, HashMap<Integer, Integer> cache, int coins[], int n)
    {
        /*
            base cases:
                if n becomes a negative number, return 0.
                if n is equal to 0, then count + 1.
                if i (indicates the value of a coin) reaches the end of array, return 0
        */
        if (n < 0) 
            return (0);
        else if (n == 0)
            return (1);
        //if i has reached the end of coins array and the total dollar amount is still greater than 0.
        if (i == coins.length && n > 0)
            return (0);
        //cached n (money) already has the # of ways?
        if (cache.containsKey(n))
            return (cache.get(n));
        //store cached value
        cache.put(n, ft_count_cache(i + 1, cache, coins, n) + ft_count_cache(i + 1, cache, coins, n - coins[i]));
        //return the already cached value...
        return (cache.get(n));
    }
    
    //Apparently, memoization does not work... not sure why...
    //but traditional DP works
    static int ft_count_DP(int n, int coins[])
    {
        /*
            approach:
                - have the 2D solution array that stores the # of ways that coin can possibly accomplish for every $                     amount
                - Rows = the length of coins (or all possible coin values), coins.length + 1
                - Columns = all the possible $ amounts, n + 1 (including $0)
                - initially the first column (which means that there is no dollar amount) contains 1 way.
                
        */
        if (n < 1) 
            return (0);
        /*REMEMBER: this is bottom up approach. Start from when dollar value is 0 or coins exceed the boundaries of           array*/
        int rows = coins.length + 1; //including when you exceed the boundaries of coin array. its value is 0.
        int columns = n + 1; //including when the dollar value is 0.
        int solution[][] = new int[rows][columns];
        int i = 0, j = 0;
        // if there is no given money, set it to 1 way
        for (i = 0; i < rows; ++i)
            solution[i][0] = 1;
        // if there is no given coins, set it to 0 way
        for (i = 0; i < columns; ++i)
            solution[0][i] = 0;
        
        /*here comes the logic: 
            loop while i < rows
                loop while j < columns
                    if coins[i] <= j
                        sol[i][j] = sol[i + 1][j] + sol[i][j - coins[i]]
                    else
                        sol[i][j] = sol[i + 1][j]
                    end
                end
            end
            return sol[rows - 1][columns - 1]
        */
        for (i = 1; i < rows; ++i)
        {
            for (j = 1; j < columns; ++j)
            {
                if (coins[i - 1] <= j)
                    solution[i][j] = solution[i - 1][j] + solution[i][j - coins[i - 1]];
                else
                    solution[i][j] = solution[i - 1][j];
            }
        }
        return (solution[rows - 1][columns - 1]);            
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
        for(int coins_i=0; coins_i < m; coins_i++)
            coins[coins_i] = in.nextInt();
        // recursive approach
        //System.out.println(ft_count_cache(0, coins, n));
        // memoization approach
        //System.out.println(ft_count_cache(0, cache, coins, n));
        // dp approach
        System.out.println(ft_count_DP(n, coins));
    }
}
