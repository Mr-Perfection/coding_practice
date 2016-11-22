/**
Your mission is simple: write a function that takes an integer 'n' and returns 'n!'.

You are guaranteed an integer argument. For any values outside the positive range, return null, nil or None. In C++, return an empty string. For positive numbers a full length number is expected for example, return 25! = '15511210043330985984000000' as a String!

Note: 0! is always equal to 1. Negative values should return null or an empty string(in C++).

For more on Factorials : http://en.wikipedia.org/wiki/Factorial
*/
import java.lang.*;
import java.util.*;
import java.math.*;
public class Kata
{
  public static String Factorial(int n) {
  	if (n == 0 || n == 1)
  		return("1");
  	else if (n < 0)
  		return (null);
  	BigInteger sol = Factorial_helper(n);
    return String.valueOf(sol);
  }
  public static BigInteger Factorial_helper(int n) {
    int i = n;
    BigInteger sol = BigInteger.valueOf(1);
    while(i > 1)
    {
    	sol = sol.multiply(BigInteger.valueOf(i));
    	i--;
    }
    return (sol);
  }

}