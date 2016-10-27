public class Solution {
    
   
    public int jump( ArrayList<Integer> list) 
    {
        //size of a list
        int n = list.size();
        int[] jumps = new int[n];
        int i,  j;
        //there are no steps from here....
        if (n == 0)
            return (-1);
        if(list.get(0) == 0 && n == 1)
            return (0);
        else if (list.get(0) == 0 && n > 1)
            return (-1);
        //iterate through i to find whether ith element is within the range of j + list.get(j)
        for (i = 1; i < n; ++i)
        {
            //initially set jumps[i] to be Integer.MAX_VALUE in order to initialize to find the minimum steps.
            jumps[i] = Integer.MAX_VALUE;
            //iterate j from 0 to find whether ith element is within the range of j + list.get(j)
            for (j = 0; j < i; ++j)
            {
                //HERE: if ith element is within the range of j + list.get(j), then count the steps.
                if (i <= j + list.get(j))
                {
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                    // break;
                }
            }
        }
        if (jumps[n - 1] == 0)
            return (-1);
        else
            return (jumps[n - 1]);
    }
}