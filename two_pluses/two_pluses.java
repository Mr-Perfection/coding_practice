import java.io.*;
import java.util.*;

public class Solution {
    
    /*
    bad = B
    good = G
    pluses = X
    */
    //mark pluses
    static void ft_mark_pluses(char arr[][], int row, int col)
    {   
        //starting from the 2nd row.
        for (int i = 1; i < row - 1; ++i)
        {
            for (int j = 0; j < col; ++j)
            {
                if (arr[i - 1][j] == 'G' && arr[i + 1][j] == 'G' )
            }
        }
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}