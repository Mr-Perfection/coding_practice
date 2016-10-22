import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next(); //str = aabbcd
        ///char char_arr[] = new char[str.length()];
        //count chars in the string. every char element has its own number of chars. ex) 2 2 1 1
        int char_count[] = new int[26];
        //count accumulate those frequencies and identify the frequency of the number of chars. ex) 2 2
        int freq[] = new int[str.length()];
        Arrays.fill(char_count, 0);
        //Arrays.fill(freq, 0);
        int i = 0;
        //get the char counts
        
        //if string length is just 1 then YES
        if (str.length() == 1)
        {
            System.out.println("YES");
            return ;
        }
        for (i = 0; i < str.length(); ++i)
        {
            char_count[str.charAt(i) - 'a'] += 1;
        }
        
        for (i = 0; i < char_count.length; ++i)
        
        {
            int x = i +  'a';
            char c = (char) x;
            //System.out.println( c +" char counts: " + char_count[i]);
        }
        //get the freq. of the number of chars
        for (i = 0; i < char_count.length; ++i)
        {
            if ( char_count[i] > 0)
                freq[char_count[i]] = freq[char_count[i]] + 1;
            else
                freq[char_count[i]] = 0;
            
        }
        //System.out.println(i +" " + " freq: " + freq[char_count[9]]);
        // System.out.println("");
        
        //get how many elements in freq. contain > 0 values
        int count = 0;
        for (i = 0; i < freq.length; ++i)
        {
            if (count > 2)
            {                
                System.out.println("NO");
                return ;
            }
            if (freq[i] > 0)
                count++;
        }
        //System.out.println("-------TEST--------" + count);
        if ( count == 1)
        {
            System.out.println("YES");
        }
        else
        {
            int temp = 0;
            int res = 0; 
            for (i = 0; i < freq.length; ++i)
            {
                
                if (freq[i] > 0)
                {
                    if (temp == res)
                    {       
                        temp = freq[i];
                    }
                    else
                    {
                        
                        res = Math.abs(temp - freq[i] * i);
                    }
                    //System.out.println("-------FREQ:--------" + freq[i] + " " + i);
                    //res = Math.abs(res - freq[i] * i);
                    
                }
            }
            if (res > 1)
            {
                //System.out.println("temp is: " + temp);
                //if temp is 1, then you can simply remove it so answer is YES
                if (temp == 1)
                {
                    System.out.println("YES");
                    return; 
                }
                System.out.println("NO");
            }
            else
                System.out.println("YES");
        }
        
        
        in.close();
    }
}