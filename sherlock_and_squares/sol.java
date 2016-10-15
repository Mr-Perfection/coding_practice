import java.io.*;
import java.util.*;
//DO NOT OVERCOMPLICATE YOURSELF. LESSONS LEARNED
public class Solution {
    /*
        this function returns # of squares from the range list.
        by using memoization I can optimize the time complexity
        Map returns true if there exists a 
    */
    
    /*can be efficient when just finding a square but not in this case...  time complex: log(n)*/
    /*static boolean ft_squares( long x, Map<Long, Boolean> squares)
    {
        
        // if there is already an answer
        if (squares.containsKey(x) == true)
        {
            return (squares.get(x)); //FALSE: if there does not exist square, TRUE: if there exists square
        }
        else
        {
            //iteration until you find there is a square
            //use binary search algorithm to find the square
            long start = 1;
            long end = x;
            while(start  <= end)
            {
                long mid = (start + end) / 2;
                if (mid * mid == x)
                {
                    //found the square
                    squares.put(x, true);
                    return (true);
                }
                else if (mid * mid > x)
                {
                    //lower the mid by 1 and set the end.
                    end = mid - 1;
                }
                else if (mid * mid < x)
                {
                    //increase the start
                    start = mid + 1;
                }
            }
        } //EOF else
        //square does not exist for x
        squares.put(x, false);
        return (false);
    }*/
    
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			System.out.println(getSquares(in.nextLong(), in.nextLong()));
		}
		in.close();
	}

	static long getSquares(long num1, long num2) {
		if (num1 == 0)
			num1++;
		Double x = Math.sqrt(num1);
		Double y = Math.sqrt(num2);
		long xLong = x.longValue();
		long yLong = y.longValue();
		long count = 0L;

		for (long i = xLong; i <= yLong; i++) {
			if ((i * i) <= num2 && (i * i) >= num1)
				count++;
		}

		return count;
	}
}