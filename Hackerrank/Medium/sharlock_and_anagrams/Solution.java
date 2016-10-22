import java.io.*;
import java.util.*;

public class Solution {
    
    
    static boolean check_anagram(String s1, String s2)//ab bc
    {
        char a[] = s1.toCharArray();
        char b[] = s2.toCharArray();
        //System.out.println(s1+" "+s2);
       int first[] = new int[26];
       int second[] = new int[26];
        Arrays.fill(first,0);
        Arrays.fill(second,0);
        int c=0;
       while (c<a.length) {
          first[a[c]-'a']++; //0 1
          c++;
       }
       c = 0;
       while (c<b.length) {
          second[b[c]-'a']++;//1 2
          c++;
       }

       for (c = 0; c < 26; c++) {
          if (first[c] != second[c])
             return false;
       }

       return true;
    }

    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       int t = in.nextInt();
        
        //iterate all test cases
        while(t > 0){
            //get the string...
            String str = in.next();
            int count = 0;
            int len = str.length();
            int i = 1;
            int j = 0;
            int k = 0;
            
            
            //abba
            //until it iterates through the entire string
            for (i = 1; i < len; ++i)
            {
                //need to get substring in str in increasing chars
                for (j = 0; j < len - i + 1; ++j)
                {
                    //get the first substring
                    String sub1 = str.substring(j, j + i); //ab
                    for (k = j + 1; k < len - i + 1; ++k)
                    {
                        String sub2 = str.substring(k, k + i);//bc
                        //System.out.println(sub1 + " " + sub2);
                        if (check_anagram(sub1, sub2))
                            count++;
                    }
                }
                //i++;
            }
            System.out.println(count);
            t--;
            
        }
        
        in.close();
    }
    
}