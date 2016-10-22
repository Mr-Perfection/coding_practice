import java.io.*;
import java.util.*;
//https://www.hackerrank.com/challenges/coin-change
public class Solution {

    /*
            Recursive solution:
            Time Complexity: O(2^n^2)
        
        */
    //top-down approach
    static long ft_recursive_sol(int i, int change ,int[] coins)
    {
        //denerating cases
        if (change  == 0) //found a way to change
            return (1);
        else if (change < 0) //if change is negative, there is no way!
            return (0);
        if (i == coins.length && change > 0)
            return (0);
        //find ways in 1) current index i and reducing the change by ith element + 2) go to next index and look for             other ways
        return (ft_recursive_sol(i, change - coins[i], coins) + ft_recursive_sol(i + 1, change, coins));
    }
    
    //very, very efficient way...Using DP. Time complex. = n^2, iterative approach (or bottom up approach or               traditional DP approach whatever.)
    static long ft_dp_sol(int change ,int[] coins)
    {
        /* 
            ROWS: length of coins + 1, 0...coins[coins.length - 1]
            COLS: the amount of change + 1, 0... change
        */
        int ROWS = coins.length + 1; //+ 1 for How many ways can you give change for 0 cents?
        int COLS = change + 1;// + 1 for How many ways can you give change for >0 cents, if you have no coins?
        long sol[][] = new long[ROWS][COLS];
        int i = 0, j = 1;
        /*
        ROWS = 4 + 1
        COLS = 5 + 1
   DISCLAIMER: ROWS indexes aren't the values of the coins except for 0!!! 0 is the case when there is no coins. For the rest, they are indexes of the coins[] array but to understand this method, lets think those are just coin values also.    
      0 1 2 3 4 5
    0 0 1 1 1 1 1       
    1 0 1 2 3 4 5
    2 0 1 2 4 6 9
    3 0 1 2 4 7 11
    4 0 1 2 4 7 12
        */
        for (i = 0; i < ROWS; ++i)
        {
            //set to 1 because you are already accomplished to give change! Base case n == 0 from recursive solution
            sol[i][0] = 1;
        }
        for (i = 0; i < COLS; ++i)
        {
            //set to 0 because with 0 coin value, you can't achieve anything.
            sol[0][i] = 0;
        }
        
        for (i = 1; i < ROWS; ++i)
        {
            for (j = 1; j < COLS; ++j)
            {
                //what if the coin value exceeds the change amount?
                if (coins[i - 1] <= j) //coins[i - 1]. Remember we added case when there is 0 coins?
                    sol[i][j] = sol[i][j - coins[i - 1]] + sol[i - 1][j];
                else 
                     sol[i][j] = sol[i - 1][j];
            }
        }
        return (sol[ROWS - 1][COLS - 1]);
        
    }
        
    public static void main(String[] args) {
        /*I have done this problem before but it will be a good practice*/
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int a[] = new int[M];
        int i = 0;
        for (i = 0; i < M; ++i)
        {
            a[i] = in.nextInt();
        }
        
        System.out.println(ft_dp_sol(N,a));
        
    }
}