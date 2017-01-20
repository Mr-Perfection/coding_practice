public class Solution {
    
    /*
    Approach:
    bruteforce
    [2, 15, 11, 7], target = 9,
    */
    
    /*  function twoSum
        @param int[] nums, an array of integers
        @param int target, the target integer that the sum of two numbers have to be matched with
        @return int[] sol, the two integers that represent a sum for the target
    */
    
    public int[] twoSum(int[] nums, int target) {
        
        //check if nums exists
        if (nums == null || nums.length == 0)
            return (null);
        
        //iterate through the nums array and check if the sum is matching
        for (int i = 0; i < nums.length; ++i)
        {
            for (int j = i + 1; j < nums.length; ++j)
            {
                //check if ith el. + jth el. is equal to target.
                if (nums[i] + nums[j] == target)
                {
                    int[] sol = new int[2];
                    sol[0] = i;
                    sol[1] = j;
                    return (sol);
                }
            }
        }
        
        return (null);
    }
}