class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        res = 0
        sum = 0

        for i in nums:
            if(i < sum + i):
                sum += i
            else: 
                sum = i
            
            if(res < sum):
                res = sum

        return res