/**
*  @param: integer n, a number that will be used to get the factor decomposition 
*  @return: string result, a string representation of theprime factor decomposition of n
**/
public class PrimeDecomp {
   
    public static String factors(int n) {
      //initializations
      int x = 2;
      StringBuilder sb = new StringBuilder();
      
        while(n > 1)
        {
          int count = 0;
          while (n % x == 0) 
          {
            count += 1;
            n /= x;
          }
          if (count > 1) sb.append("(" + Integer.toString(x) + "**" + Integer.toString(count) + ")");
          else if (count == 1) sb.append("(" + Integer.toString(x) + ")");
          x++;
        }
      return (sb.toString());
    }
       
}