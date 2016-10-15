import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n ; ++i)
        {
            String str = in.next();
            System.out.println(ft_next_perm(str));
        }
        in.close();
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
    }
    public static String ft_next_perm(String s)
    {
        int len = s.length();
        int i = len - 1;
        int pivot; 
        char[] array = s.toCharArray();
        // Find longest non-increasing suffix from the right
        while (i > 0 && Character.getNumericValue(array[i - 1]) >= Character.getNumericValue(array[i]))
            i--;
        /*
            d k h c
            array[i] => k, because d is less than k.
        */
        
        /*check if i is not zero because if i <= 0, then that means the string does not have next bigger string*/
        if (i <= 0)
            return ("no answer");
        else
        {
            pivot = i - 1;
            // Let array[i - 1] be the pivot
            // Find rightmost element that exceeds the pivot
            int j = array.length - 1;
            while (Character.getNumericValue(array[j]) <= Character.getNumericValue(array[pivot]))
                j--;
            //Swap the pivot and the rightmost element that exceeds the pivot
            char temp = array[pivot];
            array[pivot] = array[j];
            array[j] = temp;
            //Swap the remainder between pivot + 1 and the last element
            j = array.length - 1;
            pivot = pivot + 1;
            //System.out.println(array[pivot]);
            //System.out.println(array[j]);
            while( pivot < j)
            {
                temp = array[pivot];
                array[pivot] = array[j];
                array[j] = temp;
                pivot++;
                j--;
            }
        }
        
        
        
        return new String(array);
    }
}