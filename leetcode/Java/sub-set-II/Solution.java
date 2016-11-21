

/****
Passed 16/19 test cases... Timed out :(

****/
public class Solution {
    public static void subsetsWithDupHelper(List<Integer> set, List<List<Integer>> sol) 
    {
        if (!set.isEmpty())
        {
            if (!sol.contains(set))
                sol.add(new ArrayList<Integer>(set));
        }
        else
            return ;
        for (int i = 0; i < set.size(); ++i)
        {
            int temp = set.get(i);
            set.remove(i);
            subsetsWithDupHelper(set, sol);
            set.add(i,temp);
            
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        /*
        my approach (backtracking):
        nums = [1, 2, 2]
        set = []
        myFunction(nums, index, set, sol)
        {
            if index < nums.length
                if sol.contains(set) == false
                    sol.add(set)
            else
                return
            for i = index; i < nums.length; ++i
                set.add(nums[i])
                myFunction(nums, i, set, sol)
                set.remove(set.size - 1)
        }
        
        */
        Arrays.sort(nums);
        List<List<Integer>> sol = new LinkedList<List<Integer>>();
        List<Integer> set = new LinkedList<Integer>();
        sol.add(new LinkedList<Integer>());
        for (int i : nums)  set.add(i);
        subsetsWithDupHelper(set, sol);
        return (sol);
    }
}

public class Solution {
    public static void subsetsWithDupHelper(List<Integer> set, List<List<Integer>> sol) 
    {
        if (!set.isEmpty())
        {
            if (!sol.contains(set))
                sol.add(new ArrayList<Integer>(set));
        }
        else
            return ;
        for (int i = 0; i < set.size(); ++i)
        {
            int temp = set.get(i);
            set.remove(i);
            subsetsWithDupHelper(set, sol);
            set.add(i,temp);
            
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        /*
        my approach (backtracking):
        nums = [1, 2, 2]
        set = [1, 2, 2]
        []
        [1]
        [1, 2]
        [1, 2, 2]
        [2, 2]
        [2]
        */
        Arrays.sort(nums);
        List<List<Integer>> sol = new LinkedList<List<Integer>>();
        List<Integer> set = new LinkedList<Integer>();
        // sol.add(new LinkedList<Integer>());
        // for (int i : nums)  set.add(i);
        int j = 0;
        //incrementally adding the set
        while (j < nums.length)
        {
        	// if (!sol.contains(set))
        	sol.add(new LinkedList<>(set));
        	for (int k = 0; k <= j; ++k) set.add(nums[k]);
        	j++;
        }
		//decrementally reducing the set the set
		while (--j > 0)
        {
        	set.removeFirst();
        	sol.add(new LinkedList<>(set));
        }
        // subsetsWithDupHelper(set, sol);
        return (sol);
    }
}




/*most optimal solution*/



class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> S = new ArrayList<Integer>();
        
        //case 1: empty set is also subset of any sets
        result.add(new ArrayList<Integer>());
        //case 2: nums array is null or the length of array is zero, then return set 
        if (nums == null || nums.length == 0) {
            return result;
        }
        //create a list that will store nums
        for (int i = 0; i < nums.length; ++i) S.add(nums[i]);
        //sort the sets in increasing order
        Collections.sort(S);
        helper(result, S, new ArrayList<Integer>(), 0);
        return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> S, List<Integer> cur, int i) {
        //backtracking
        for (int j = i; j < S.size(); j++) {
            //case 3.1: if index  is greater than index i AND jth element and j-1 element are equal, it's a duplicate so skip.
            if (j > i && S.get(j) == S.get(j - 1)) {
                continue;
            }
            cur.add(S.get(j));
            result.add(new ArrayList<Integer>(cur));
            helper(result, S, cur, j + 1);
            cur.remove(S.get(j));
        }
    }
}