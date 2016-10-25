public class Solution {
    
	public long Mod(long a, long b, long c) {
	    /*
	    
	    how it works?
	    a^b % c = 
	    5^3 % 7 = 5
	    //when it is odd
	    5 % 7 = 5   25 % 7 = 4
	    20 % 7 =6
	    return (a % c * a^(b-1) % 7)
	    //when it is even
	    5^4 % 7 = 5^2 % 7 * 5^2 % 7
	    return (a^(b/2) % c * a^(b/2) % c)
	    
	    
	    */
	    if (a == 0)
	        return (0);
	    if (b == 0)
            return (1);
	    else if ( b % 2 == 0)
	    {
	        long temp = Mod(a, b/2, c);
	        return (temp * temp % c);
	    }
	    else
	    {
	        long value = ((a % c) * Mod(a, b - 1, c)) % c;
	        if (value < 0)
	            return (c + value);
	        return (value);
	    }
	    
	}
}
