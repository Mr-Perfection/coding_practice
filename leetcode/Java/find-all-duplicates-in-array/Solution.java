public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        if (nums == null)
            return (null);
        //sort an array, nlogn
        Arrays.sort(nums);
        List<Integer> solution = new LinkedList<Integer>();
        
        if (nums.length == 1)
            return (solution);
        /*
        only need to check i - 1 and i if they are equal to find the duplicate
        */
        for (int i = 1; i < nums.length; ++i)
        {
            if (nums[i - 1] == nums[i])
                solution.add(nums[i]);
        }
        return (solution);
    }
}