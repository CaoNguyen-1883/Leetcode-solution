class Solution(object):
    def maximumCount(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l = 0
        r = len(nums) - 1

        while l <= r:
            m = (l + r) / 2;
            if nums[m] >= 0:
                r = m - 1
            else:
                l = m + 1

        neg = l

        while l < len(nums) and nums[l] == 0:
            l += 1

        pos = len(nums) - l

        return max(neg, pos)