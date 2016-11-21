/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    var sum = [];
    var left = nums.length - 1;
    for (var i = 0; i < nums.length - 1; ++i)
    {
        var j = i;
        while (++j  < nums.length)
        {
            if ((nums[i] + nums[j]) == target)
            {
                sum.push(i);
                sum.push(j);
                return (sum);
            }
        }
    }
};