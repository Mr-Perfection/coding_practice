import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                arr[i][j] = in.nextInt();
            }
        }
        /*
            hour glass: i = rows, j = cols
            for i = 0 ... arr.length - 1
            int hour_glass = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1]
                                + arr[i +2][j] + arr[i +2][j + 1] + arr[i + 2][j + 2]
        
        */
        int max = Integer.MIN_VALUE;
        int hour_glass = 0;
        for (int i = 0; i < arr.length - 2; ++i)
        {
            for (int j = 0; j < arr[0].length - 2; ++j)
            {
                //if (i + 2 < arr.length - 2 && j + 2<)
                hour_glass = Math.max( hour_glass ,arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1]
                                + arr[i +2][j] + arr[i +2][j + 1] + arr[i + 2][j + 2]);
                //System.out.println("hour glass" + hour_glass);
            }
            //max = Math.max(max, hour_glass);
        }
        
        System.out.println("max is " + hour_glass);
     
    }
}
