public class Solution {
    
   //memoization
   public int ft_helper(ArrayList<Integer> a, int index, HashMap<Integer, Integer> dp)
   {
       int n = a.get(index);
       int j, min = Integer.MAX_VALUE;
       if (index >= a.size())
            return (0);
        if (index + n >= a.size() - 1)
            return (1);
        if (!dp.containsKey(index))
        {
            //find the min. of all the possible jumps from index...index + n
            for (j = index + 1; j <= index + n && j < a.size(); ++j)
            {
                //map does not have a key?
                if (a.get(j) != 0)
                {
                    if (!dp.containsKey(j))
                        dp.put(j, ft_helper(a, j, dp));
                    int x = dp.get(j);
                    min = Math.min(min, x + 1);    
                }
                else
                    min = Math.min(min, Integer.MAX_VALUE);
                
                //System.out.println("min is: " + min);
            }    
            dp.put(index, min);
        }
        if (index > 10)
            System.out.println("dp is: " + dp.get(index)  + "index is: " + index);
        return (dp.get(index));
   }
    public int jump( ArrayList<Integer> a) 
    {
       
       HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
       return (ft_helper(a, 0,memo ));
    }
}


public class Solution {
    
   
    public int jump( ArrayList<Integer> list) 
    {
        //size of a list
        int n = list.size();
        int[] jumps = new int[n];
        
        int i,  j, k;
        //there are no steps from here....
        if (n == 0)
            return (-1);
        if(list.get(0) == 0 && n == 1)
            return (0);
        else if (list.get(0) == 0 && n > 1)
            return (-1);
        Arrays.fill(jumps, -1);
        jumps[0] = 0;
        for(i = 0; i < n - 1; ++i)
        {
            j = (i + list.get(i) > n - 1) ? n - 1 : i + list.get(i);
            if (jumps[i] != -1)
                for (k = j; jumps[k] == -1 && k >= 0; --j )
                    jumps[k] = jumps[i] + 1; 
        }
        
       
       return (jumps[n - 1]);
    }
}