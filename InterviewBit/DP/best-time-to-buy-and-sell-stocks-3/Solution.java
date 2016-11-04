public class Solution {
    public static void print_array(int[] arr)
    {
        for (int i = 0; i < arr.length; ++i)
            System.out.print("element: " + arr[i]);
        System.out.println("");
    }
	public int maxProfit(final List<Integer> a) {
	    
	    if (a == null || a.size() <= 0)
	        return (0);
	        
	    int left[] = new int[a.size()];
	    int right[] = new int[a.size()];
	    int profit = 0;
	    
	    int max = 0, min = 0;
	    left[0] = 0;
	    right[a.size() - 1] = 0;
	    min = a.get(0);
	    //try to look for the lowest buying point + selling point.
	    for (int i = 1; i < a.size(); ++i)
	    {
	        min = Math.min(min, a.get(i));
	        left[i] = Math.max(left[i - 1], a.get(i) - min);
	    }
	    
	    max = a.get(a.size() - 1);
	    //try to look for the highest selling point + buying point.
	    for (int i = a.size() - 2; i >= 0; --i)
	    {
	        max = Math.max(max, a.get(i));
	        right[i] = Math.max(right[i + 1], max - a.get(i));
	    }
	    // print_array(left);
	    //print_array(right);
	    for (int i = 0; i < a.size(); ++i)
	        profit = Math.max(profit, right[i] + left[i]);
	    return (profit);
	}
}
