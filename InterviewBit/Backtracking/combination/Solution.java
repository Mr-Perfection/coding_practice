public class Solution {
    
    static void ft_combination(ArrayList<ArrayList<Integer>> solution, int n, int k, int x, ArrayList<Integer> combo)
    {
    	if (k <= 0)
    	{
    		//do something to terminate.
    		ArrayList<Integer> temp = new ArrayList<Integer>(combo);
    		solution.add(temp);
    		return ;
    	}
    	for (int i = x; i <= n; ++i)
    	{
    		combo.add(i);
    		ft_combination(solution, n, k - 1, i + 1, combo);
    		combo.remove(combo.size() - 1);
    	}
    }
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
	    /*
	        k is the size of the arraylist.
	        0...n is the numbers that you can fill in.
	        no repeats
	    */
	    ArrayList<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>();
	    ArrayList<Integer> combo = new ArrayList<Integer>();

	    ft_combination(solution, n, k, 1, combo);
	    return (solution);
	    
	    
	}
	
}
