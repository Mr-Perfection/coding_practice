import java.lang.*;
import java.util.*;
public class PerfectPower {
  public static int[] isPerfectPower(int n) {
    //m^k = n
    //iterate through m > 1
    for ( int m = 2; m <= Math.round((Math.log(n) / Math.log(2)); ++m)
    {
    
      //timed out.O(n^2) ehhh wtf.. use built in function
      //check if n is divisible by m
//       if (n % m == 0)
//       {
//         int temp = n;
//         int k = 0;
        
//         while (temp % m == 0 && temp > 1)
//         {
//           temp /= m;
//           k++;
//         }
//         if (temp == 1)
//           return (new int[]{m, k});
        int k = 2;
//         System.out.println("m " + m +" n " + n );
        if (n % m == 0)
        {
          
          double temp = Math.pow(m, k);
          while (temp <= n)
          {
            if (temp == n)
              return (new int[]{m, k});
            if(n % temp != 0)
              break ;
            temp *= m;
            k++;
          }
//           System.out.println("temp is: " + temp + "m " + m +" n " + n );
            
        }
        
      }
    //}
    return (null);
  }
}



import java.lang.*;
import java.util.*;
public class PerfectPower {
  public static int[] isPerfectPower(int n) {
    //m^k = n
    /*Wow, I spent 2 hours on this annoying? issue. 
      I was able to optimize my algorithm by x1000 times better by (Math.pow(m, k) > n) checking whether the rest of m^k exceeds n.
      If it exceeds n, there is no need to check the rest. Lessons learned... 25 minutes taken to solve this problem without timeout issue.
    */
    for ( int m = 2; m <= n / 2; ++m)
    { 
        int k = 2;
        if (Math.pow(m, k) > n)
          break ;
        if (n % m == 0)
        {
          double temp = Math.pow(m, k);
          while (temp <= n)
          {
            if (temp == n)
              return (new int[]{m, k});
            if(n % temp != 0)
              break ;
            temp *= m;
            k++;
          }
        }
      }
    return (null);
  }
}