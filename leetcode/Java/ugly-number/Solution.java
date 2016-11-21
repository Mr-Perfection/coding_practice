public class Solution {
    public boolean isUgly(int num) {
        /*
        2, 3, 5
        
        test1:
        6
        2 * 3 = 6
        8
        2 * 2 * 2 = 8
        14
        2 * 7 = 14
        */
        if (num == 0)
            return (false);
        if (num == 1 || num == 2 || num == 3|| num == 5)
            return (true);
        
        //check if num can be divided by 2, 3, or 5.
        if (num % 2 == 0)
            return (isUgly(num / 2));
        else if (num % 3 == 0)
            return (isUgly(num / 3));
        else if (num % 5 == 0)
            return (isUgly(num / 5));
        else
            return (false);
    }
}