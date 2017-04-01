# 237 / 313 test cases passed.
class Solution(object):
    def helper(self,s,t_list,index,s_list,table):
        if len(t_list) == 3:
            if not(sum(t_list)):
                t_list = sorted(t_list)
                if t_list not in s_list:
                    s_list.append(t_list[:])
            return

        if index >= len(s): return

        for i in range(index,len(s)):
            t_list.append(s[i])
            self.helper(s,t_list,i+1,s_list)
            t_list.pop()

    def threeSum(self, nums):
        sol = []
        self.helper(nums,[],0,sol)
        return sol


# 311 / 313 test cases passed.
#
class Solution(object):
    def threeSum(self, nums):
        sol = []
        # approach #1
        # run a loop from i = 0..len(nums)-2
        # create an empty hashtable
        # run a loop from j = i+1..len(nums)-1
        # if -(nums[i] + nums[j]) is in hashmap
        #  then sol.add([nums[i],nums[j],-(nums[i] + nums[j]))
        # else
        #  then set.add(nums[j])
        nums = sorted(nums)
        for i in range(len(nums)-1):
            n_set = set()
            for j in range(i+1,len(nums)):
                if -(nums[i]+nums[j]) in n_set:
                    x = [nums[i],nums[j],-(nums[i] + nums[j])]
                    if x not in sol:
                        sol.append([nums[i],nums[j],-(nums[i] + nums[j])])
                else:
                    n_set.add(nums[j])
        return sol

class Solution(object):
    def threeSum(self, nums):
        res = []
        nums.sort()
        for i in range(len(nums)-2):
            # skip duplicates
            if i > 0 and nums[i]==nums[i-1]:
                continue

            left,right = i+1,len(nums)-1
            while left < right:
                s = nums[i] + nums[left] + nums[right]
                if s < 0:
                    left += 1
                elif s > 0:
                    right -= 1
                else:
                    res.append([nums[i],nums[right],nums[left]])
                    # prevent any duplicates
                    while left < right and nums[left] == nums[left+1]:
                        left += 1
                    while left < right and nums[right] == nums[right-1]:
                        right -= 1
                    right -= 1
                    left += 1
        return res
