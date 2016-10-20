import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static int[] arrayLeftRotation(int[] a, int n, int k) {
        
      List<Integer> list = new ArrayList<Integer>();
      int i = 0;
        
      for (i = k; i < n; ++i)
      {
          list.add(a[i]);
      }
      
      for (i = 0; i < k; ++i)
      {
          list.add(a[i]);
      }
      
      for (i = 0; i < n; ++i)
      {
          a[i] = list.get(i);
      }
      
      return (a);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
      
        int[] output = new int[n];
        output = arrayLeftRotation(a, n, k);
        for(int i = 0; i < n; i++)
            System.out.print(output[i] + " ");
      
        System.out.println();
      
    }
}
