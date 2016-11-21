/*Write function scramble(str1,str2) that returns true if a portion of str1 characters can be rearranged to match str2, otherwise returns false.

For example:
str1 is 'rkqodlw' and str2 is 'world' the output should return true.
str1 is 'cedewaraaossoqqyt' and str2 is 'codewars' should return true.
str1 is 'katas' and str2 is 'steak' should return false.

Only lower case letters will be used (a-z). No punctuation or digits will be included.
Performance needs to be considered*/
import java.lang.*;
import java.util.*;
public class Scramblies {
    
    public static boolean scramble(String str1, String str2) {
    	int[] mem = new int[256];
    	Arrays.fill(mem, 0);
    	for (int i = 0; i < str2.length(); ++i)
    		mem[str2.charAt(i) - '0']++;
    	for (int j = 0; j < str1.length(); ++j)
    		mem[str1.charAt(j) - '0']--;
    	for (int m = 0; m < mem.length; ++m)
    		if (mem[m] > 0)
    			return (false);
    	return (true);
        
    }
}