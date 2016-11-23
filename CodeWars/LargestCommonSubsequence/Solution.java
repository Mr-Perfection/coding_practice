/*
Write a function called LCS that accepts two sequences, and returns the longest subsequence common to the passed in sequences.

Subsequence

A subsequence is different from a substring. The terms of a subsequence need not be consecutive terms of the original sequence.

Example subsequence

Subsequences of "abc" = "a", "b", "c", "ab", "ac", "bc"

LCS examples

Solution.lcs("abcdef", "abc") => returns "abc"
Solution.lcs("abcdef", "acf") => returns "acf"
Solution.lcs("132535365", "123456789") => returns "12356"
Notes

Both arguments will be strings
Return value must be a string
Return an empty string if there exists no common subsequence
Both arguments will have one or more characters (in JavaScript)
All tests will only have a single longest common subsequence. Don't worry about cases such as LCS( "1234", "3412" ), which would have two possible longest common subsequences: "12" and "34".
Note that the Haskell variant will use randomized testing, but any longest common subsequence will be valid.
**/
public class Solution {
	//need to check whether x matches with y or not.
    /*
      option 1: bruteforce
        -iterate through x and y in two loops. time complexity : O(n^2)
      option 2: greedy approach: find suboptimal solution until finding optimal solution.
        -iterate through x and y and, if matching store it into the a1 list.
         if not matching, iterate through y until it finds the matching character.
        -iterate through y and x and, if matching store it into the a2 list.
         if not matching, iterate through x until it finds the matching character.
        -check a1 and a2 and decide which one is longer.
        -Return the longer one as a string. 
        -O(2n) = O(n)
    */

    public static String lcs(String x, String y) {
    	int j;
    	StringBuilder a1 = new StringBuilder();
    	StringBuilder a2 = new StringBuilder();
        for (int i = 0; i < x.length(); ++i)
        {
        	j = i;
        	while(j < y.length() && x.charAt(i) != y.charAt(j))
        		j++;
        	if (j >= y.length()) 
        		break;
        	a1.append(y.charAt(j));
        }
        for (int i = 0; i < y.length(); ++i)
        {
        	j = i;
        	while(j < x.length() && y.charAt(i) != x.charAt(j))
        		j++;
        	if (j >= x.length()) 
        		break;
        	a2.append(x.charAt(j));
        }
        return ((a1.length() > a2.length()) ? a1.toString() : a2.toString());

    }
}

//accepted solution :D  O(n)
import java.util.*;
import java.lang.*;
public class Solution {
    public static String lcs(String x, String y) {
      int j = 0;
      StringBuilder a1 = new StringBuilder();
      StringBuilder a2 = new StringBuilder();
        for (int i = 0; i < x.length(); ++i)
        {
          int k = j;
          while(k < y.length() && x.charAt(i) != y.charAt(k))
            k++;
          if (k < y.length() && x.charAt(i) == y.charAt(k)) 
          {
            a1.append(x.charAt(i));
            j = k + 1;
          }
        }
        j = 0;
        for (int i = 0; i < y.length(); ++i)
        {
          int k = j;
          while(k < x.length() && y.charAt(i) != x.charAt(k))
            k++;
          if (k < x.length() && y.charAt(i) == x.charAt(k)) 
          {
            a2.append(y.charAt(i));
            j++;
          }
        }
        System.out.println("x: "+x);
        System.out.println("y: "+y);
        System.out.println(a1);
        System.out.println(a2);
        return ((a1.length() > a2.length()) ? a1.toString() : a2.toString());

    }
}