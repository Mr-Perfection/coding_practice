<<<<<<< HEAD
public class Solution {
    public static void combinationSumHelper(List<List<Integer>> solution, List<Integer> combo, int x, int limit, int target)
    {
        if (combo.size() == limit && target == 0)
        {
            Collections.sort(combo);
            if (!solution.contains(combo))
            {
                List<Integer> temp = new ArrayList<Integer>(combo);
                solution.add(temp);
            }
            return ;
        }
        else if (combo.size() == limit && target != 0) return ;
        if (x > 9) return ;
        for (int i = x; i <= 9; ++i)
        {
            combo.add(i);
            combinationSumHelper(solution, combo, i + 1, limit, target - i);
            combo.remove(combo.size() - 1);
        }
        
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> solution = new ArrayList<List<Integer>>();
        List<Integer> combo = new ArrayList<Integer>();
        combinationSumHelper(solution, combo, 1, k, n);
=======
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
>>>>>>> c75d05178fecf44ecd2fcfda842e0414311e80f0
        return solution;
    }
}