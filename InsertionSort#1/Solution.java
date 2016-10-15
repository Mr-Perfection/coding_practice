import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    


    public static void insertIntoSorted(int[] ar) {  
        int i, j;
        int last = ar[ar.length - 1];   //store the last element in the array.
        int lastIndex = ar.length -1;
        for(i=ar.length - 1;i>=0;--i)   //decrements from the last element in array
        {
            if(i-1>=0)
            {
                int prev = ar[i-1];
                
                if(prev > last)
                {
                  ar[i] = ar[i-1];    //if previous element has a greater value than last, then prev = last.
                }
                else if(prev < last)
                {
                    if(ar[lastIndex] != last)
                    {
                        ar[i] = last;
                    }
                    
                }
                
                printArray(ar);
            }
            
        }
    }
    
    
/* Tail starts here */
     public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
         for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
         }
         insertIntoSorted(ar);
    }
    
    
    private static void printArray(int[] ar) {
      for(int n: ar){
         System.out.print(n+" ");
      }
        System.out.println("");
   }
    
    
}
