/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.

*/

/*
    ai = (1, 2, 3, 7, 5, 3, 10)
    i  = (1, 2, 3, 4, 5, 6, 7)
     (i, 0) to (i, ai) create a biggest container.
     
     approach:
            find two vertical lines that have the longest i - j value (or width)
    
    left = 0
    right = a.length - 1
    //since the side cannot be slanted it can't have (i, 0) to (i + j, ai)
    while left < right
        min_side = Math.min(a[left], a[right])
        max_area = Math.max(min_side * (right - left), max_area)
        if  a[left] < a[right]
            left++
        else
            right--
        
    end
    return max_area
   
        
            
**/
public class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int min_side = Integer.MAX_VALUE;
        int max_area = 0;
        if (height == null)
            return (0);
        while (left < right)
        {
            min_side = Math.min(height[left], height[right]);
            max_area = Math.max(min_side * (right - left), max_area);
            if  (height[left] < height[right])
                left++;
            else
                right--;
        }
        return max_area;
    }
}