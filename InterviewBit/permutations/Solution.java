public class Solution {
    
    public static void ft_swap(ArrayList<Integer> list, int i, int j)
    {
    	int left = list.get(i);
    	int right = list.get(j);
    	list.set(i, right);
    	list.set(j, left);
    }
    public static void ft_permute(ArrayList<ArrayList<Integer>> solution, ArrayList<Integer> list, int left)
    {
        if (left >= list.size())
        {
            ArrayList<Integer> a = new ArrayList<Integer>();
            for (int j = 0; j < list.size(); ++j)
                a.add(list.get(j));
            solution.add(a);
            return ;
        }
        for (int i = left; i < list.size(); ++i)
        {
            ft_swap(list, left, i);
            ft_permute(solution, list, left + 1);
            ft_swap(list, left, i);
        }
    }
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
	    int n = a.size();
	    int i = 0;
	    int j = 0;
	    ArrayList<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>();
	    /**
	    use backtracking
	        123             213               321
	  12 3    13 2     21 3     23 1     32 1       31 2
	  **/
	    ft_permute(solution, a, 0);
	    return (solution);
	}
}









//REDOOOOO!



public class Solution {
    
    public static void ft_swap(ArrayList<Integer> list, int i, int j)
    {
    	int left = list.get(i);
    	int right = list.get(j);
    	list.set(i, right);
    	list.set(j, left);
    }
    public static void ft_permute(ArrayList<ArrayList<Integer>> solution, ArrayList<Integer> list, int left)
    {
        //terminating case, if the left index is greater than list.length or out of bounds
        if (left >= list.size())
        {
            //here re-create arraylist to store as unique list into the solution
            ArrayList<Integer> a = new ArrayList<Integer>();
            for (int i = 0; i < list.size(); ++i)
            {
                //do something...
                a.add(list.get(i));
            }
            solution.add(a);
            return ;
        }
        //use backtracking algo. to find the solution.
        for (int i = left; i < list.size(); ++i)
        {
            //swap list(left) and list(right)
            ft_swap(list, left, i);
            ft_permute(solution, list, left + 1); //move to next index.
            ft_swap(list, left, i); //swap back to original
        }
       
    }
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
	    int n = a.size();
	    int i = 0;
	    int j = 0;
	    ArrayList<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>();
	    /**
	    use backtracking
	        123             213               321
	  12 3    13 2     21 3     23 1     32 1       31 2
	  **/
	    ft_permute(solution, a, 0);
	    
	    return (solution);
	}
}

