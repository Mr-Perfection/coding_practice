"""
A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate between
positive and negative. The first difference (if one exists) may be either positive or negative.
A sequence with fewer than two elements is trivially a wiggle sequence.

For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative.
In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its first two differences are positive and the second
because its last difference is zero.
Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence.
A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence,
leaving the remaining elements in their original order.
"""
class Solution(object):
    def wiggleMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        [1,7,4,9,2,5]
        =>(6,-3,5,-7,3)

        my approach:
        wml(nums,n,neg,prev):
            if n == 0:
                return 0
            if neg == None:
                neg = prev < nums[n] ? True:False
            if prev - nums[n] > 0:
                if neg:

        """


# wow..
class Solution(object):
    def wiggleMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        get rid of all the repeating values
        create triples
        check increasing and decreaing
        return count of the trues and add 2
        """
        print(nums)
        norep = [num for num, _ in itertools.groupby(nums)] #removes repeating values.
        print(norep)
        triples = zip(norep, norep[1:], norep[2:])
        print(triples)
        return sum((b>a) == (b>c) for a,b,c in triples) + + len(norep[:2])
