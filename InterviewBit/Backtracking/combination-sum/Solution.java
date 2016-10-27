public class Solution {
    
    /*
	        backtracking approach
	        [ 8, 10, 6, 11, 1, 16, 8 ]
	        step 1
	        look for list(i) * list()
	    	
	*/   
    public static void ft_combination(ArrayList<ArrayList<Integer>> solution, ArrayList<Integer> list, ArrayList<Integer> store, int target, int index)
    {
    	//terminating case if target becomes 0 
    	if (target == 0)
    	{
    		if (store == null || store.isEmpty())
    			return ;
    		ArrayList<Integer> temp_list = new ArrayList<Integer>();
    		//do something terminating case.
    		 for (int i = 0; i < store.size(); ++i)
    		 	temp_list.add(store.get(i));
    		solution.add(temp_list);
    		return ;
    	}
    	else if (target < 0)
    		return ;
    	for (int i = index; i < list.size(); ++i)
    	{
    		if (target < list.get(i))
    			return ;
    		store.add(list.get(i));
    		ft_combination(solution, list, store, target - list.get(i), i);
    		store.remove(store.size() - 1);
    	}




    }
	public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> list, int target) {
	    ArrayList<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>();
	    ArrayList<Integer> store = new ArrayList<Integer>();
	    ArrayList<Integer> new_list = new ArrayList<Integer>();
	    Collections.sort(list);
	    //need to get rid of the duplicates in the list before using it.
	    for (int i = 0; i < list.size(); ++i)
	    {
	    	int item = list.get(i);
	    	if(!new_list.contains(item))
	    		new_list.add(item);
	    }
	    ft_combination(solution, new_list, store, target, 0);
	    return (solution);
	}
}
