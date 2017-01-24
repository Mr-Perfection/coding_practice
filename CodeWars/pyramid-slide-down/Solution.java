import java.lang.*;
import java.util.*;

public class LongestSlideDown {

    public static int longestSlideDown(int[][] pyramid) {
       
       //bottom up approach
       //iterate through the rows of pyramid i=last row - 1..0
       for (int i = pyramid.length - 2; i >= 0; --i)
       {
         //iterate from j=0..pyramids[i].length-1
         for (int j = 0; j < pyramid[i].length; ++j)
            pyramid[i][j] = pyramid[i][j] + Math.max(pyramid[i+1][j],pyramid[i+1][j+1]);           
       }
       return (pyramid[0][0]);
    }
}