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
        return solution;
    }
}