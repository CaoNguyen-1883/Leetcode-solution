class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        maxDistant = nums[0]
        i = 0

        while(i < len(nums) and i <= maxDistant):
            if(maxDistant < i + nums[i]):
                maxDistant = i + nums[i]
            i += 1

        return i == len(nums)