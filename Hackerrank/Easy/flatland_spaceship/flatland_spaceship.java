import java.io.*;
import java.util.*;

public class Solution {
    
    //calcuate all the min distances from i
    static int ft_dist( int i, Set<Integer> set)
    {
        int temp = 0;
        int min = Integer.MAX_VALUE;
        for(int x : set)
        {
            if (min == 1)
                break;
            temp = i < x ? (x - i) : (i - x);
            //System.out.println("i is: " + i + "temp is: " + temp + "min is: " + min);
            if(min > temp)
                min = temp;
                
        }
        //System.out.println("min is: " + min);
        return min;
        
    }
    //find the maximum distnace of all distances
    static int ft_max_dist( List<Integer> list)
    {
        int max = 1;
        for( int i = 0; i < list.size(); ++i)
        {
            if (max < list.get(i))
                max = list.get(i);
        }
        return (max);
        
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        List<Integer> distance = new ArrayList<Integer>();
        Set<Integer> m_set = new HashSet<Integer>();
        //int[] m_arr = new int[m];
        /*
            5 2
            0 4 < becomes m_arr array
            0 1 2 3 4
              1 2 3
            0       4
        */
        for (int i = 0; i < m; ++i)
            m_set.add(in.nextInt());
            
        if (n == m)
        {
           System.out.println("0");
           in.close();
           return ; 
            
        }  
        else
        {
            
            for (int i = 0; i < n; ++i)
            {
                if (m_set.contains(i) == false)
                    distance.add(ft_dist(i, m_set));
                
            }
            //System.out.println("distances: "+distance);
        }
        System.out.println(ft_max_dist(distance));
        in.close();
    }

}