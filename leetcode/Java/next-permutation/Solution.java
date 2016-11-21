public class Solution {
    
    public static void reverse_permutation(int j, int k, int[] nums)
    {
        
        while (j < k)
        {
            int temp = nums[j];
            nums[j] = nums[k];
            nums[k] = temp;
            j++;
            k--;
        }
    }
    public static void reverse_permutation(int[] nums)
    {
        int j = 0;
        int k = nums.length - 1;
        while (j < k)
        {
            int temp = nums[j];
            nums[j] = nums[k];
            nums[k] = temp;
            j++;
            k--;
        }
    }
    public static void swap(int i, int j, int[] nums)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void nextPermutation(int[] nums) {
        //iterate from the left and find the element that is decreasing ex) 1, 1, 5  => 1
        int index = nums.length - 1;
        int i, j, k; 
        //[1, 2, 3, 6, 5]
        //[1, 2, 5, 6, 3]
        //[1, 2, 5, 3, 6]
        
        //[1, 2, 3, 6, 5, 3]
        //[1, 2, 5, 6, 3, 3]
        //[1, 2, 5, 3, 6, 3]
        //[1, 2, 5, 3, 3, 6]
        for (i = nums.length - 2; i >= 0; --i)
        {
            if (nums[i] < nums[i + 1])
            {
                break;
            }
        }
        //if there doesn't exist decreasing elemeent, reverse the array.
        if (i == -1)
        {
            reverse_permutation(nums);
            return ;
        }
        
        k = nums.length - 1;
        //decrements until nums[i] != nums[k]
        while (nums[i] >= nums[k] && i < k)
            k--;
        //swap the nums[k] and nums[i]
        swap(i, k, nums);
        reverse_permutation(i + 1, nums.length - 1, nums);
        // for(j = nums.length - 1; j > i + 1; --j)
        //     swap(j, j - 1, nums);
        //[5,4,7,5,3,2]
        //[5,5,7,4,3,2]
    }
}