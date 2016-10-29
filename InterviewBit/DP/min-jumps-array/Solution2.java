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