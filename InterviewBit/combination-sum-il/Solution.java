public class Solution {
    public static void ft_find_combos(ArrayList<ArrayList<Integer>> solution, ArrayList<Integer>  candidates, ArrayList<Integer> combo, int target, int index)
    {

    	if (index >= candidates.size() && target != 0)
    		return ;
    	//if the target becomes zero or lower then terminates!
    	if (target == 0)
    	{
    		if (solution.contains(combo))
    			return;
    		//answer!
    		ArrayList<Integer> temp = new ArrayList<Integer>(combo);
    		solution.add(temp);
    		return ;
    	}
    	else if (target < 0)
    		return ;
    	

    	//look for which number can work. No repeated candidate!
    	for (int i = index; i < candidates.size(); ++i)
    	{
    		if (target < candidates.get(i))
    			return ;
    		combo.add(candidates.get(i));
    		ft_find_combos(solution, candidates, combo, target - candidates.get(i), i + 1);
    		combo.remove(combo.size() - 1);
    	}

    }
	public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> candidates, int target) {
		ArrayList<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> combo = new ArrayList<Integer>();
		Collections.sort(candidates);

		ft_find_combos(solution, candidates, combo, target, 0);
	    return (solution);
	    
	}
}
