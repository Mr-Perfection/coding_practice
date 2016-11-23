//Use backtracking
public class Solution {
    public static void findCombinationSum(int[] candidates, int index, int target, List<Integer> combo, List<List<Integer>> solution)
    {   
        if (target == 0)
        {
            List<Integer> part = new ArrayList<Integer>(combo);
            Collections.sort(part);
            //need to check the uniqueness of the part-solution.
            if (solution.contains(part)) return ;
            solution.add(part);
        }
        else if (target < 0)
            return ;
        for (int i = index; i < candidates.length; ++i)
        {
            combo.add(candidates[i]);
            findCombinationSum(candidates, 0, target - candidates[i], combo, solution);
            combo.remove(combo.size() - 1);
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> solution = new ArrayList<List<Integer>>();
        List<Integer> combo = new ArrayList<Integer>();
        // Arrays.sort(candidates);
        findCombinationSum(candidates, 0, target, combo, solution);
        return solution;
    }
}