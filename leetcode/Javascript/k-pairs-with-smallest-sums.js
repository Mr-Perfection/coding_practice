/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @param {number} k
 * @return {number[][]}
 */
var kSmallestPairs = function(nums1, nums2, k) {
    /*
    my assumptions:
        the nums1 and nums2 might have the negative numbers
        the total possible pairs can be less than k.
    My approach:
        my answer should be comprised of lowest number pairs 0th... < k th
    
    Bruteforce O(n^2):
    
    for i = 0; i < nums1.length; ++i
        for j = 0; j < nums2.length; ++j //1 1 3     2 3 4
            if pairs.isempty == false 
            && pairs[pairs.length - 1][0] + pairs[pairs.length - 1][1] > nums1[i] + nums2[j]
                swap()
            else
                pairs.push()
        end
    end
    return pairs.splice(0, k)
    */
    var pairs = [];
    for (var i = 0; i < nums1.length; ++i)
    {
        for (var j = 0; j < nums2.length; ++j)
        {
            
            pairs.push([nums1[i], nums2[j]]);
            ///console.log("pairs: " + pairs);
        }
    }
    for (i = 0; i < pairs.length; ++i)
    {
        j = pairs.length - 1;
        while (j > i)
        {
            var curr = pairs[i][0] + pairs[i][1];
            var temp = pairs[j][0] + pairs[j][1];
            var temp_arr = pairs[j];
            if (curr > temp)
            {
                pairs[j] = pairs[i];
                pairs[i] = temp_arr;
            }
            j--;
        }
        
    }
    //console.log("pairs: " + pairs);
    return (pairs.splice(0, k));
};




