import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    //finding how many ways that coins can add up to money.
    /*
        i tracks the element in array
        money is the total amount of money left
        coins are the array of coin values
    */
    //dynamic approach
    public static long makeChange( int[] coins, int money) {
        //rows as coins length + 1 (including no coins) and columns as money + 1 (including 0)
        int rows = coins.length + 1;
        int columns = money + 1;
        long[][] solution = new long[coins.length + 1][money + 1];
        int i = 0;
        //if no given money, there is 1 way
        for (i = 0; i < rows; ++i)
        {
            solution[i][0] = 1;
        }
        
        //if no given coins, there is 0 way
        for (i = 0; i < columns; ++i)
        {
            solution[0][i] = 0;
        }
        for(i = 1; i < rows; ++i)
        {
            for(int j = 1; j < columns; ++j)
            {
                //if the coin value is less or equal to j (or money amount)
                if (coins[i - 1] <= j)
                    solution[i][j] = solution[i - 1][j] + solution[i][j - coins[i - 1]];
                else //is equal to the value from the top
                    solution[i][j] = solution[i - 1][j];
            }
        }
        return (solution[rows - 1][columns - 1]);
    }
    public static long makeChange(int i, int[] coins, int money) {
        //if money is less than zero then no change
        if (money < 0)
            return (0);
        //if moeny is equal to zero then return 1 way
        if (money == 0)
            return (1);
        //if i is at its max. and money is greater than 0, then return no change
        if (i == coins.length && money > 0)
            return (0);
        
        return (makeChange( i, coins, money - coins[i]) + makeChange(i + 1, coins, money));
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for(int coins_i=0; coins_i < m; coins_i++){
            coins[coins_i] = in.nextInt();
        }
        System.out.println(makeChange(coins, n));
    }
}
