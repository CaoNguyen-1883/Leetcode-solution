import math

class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        res = math.inf
        summ = 0
        l = 0

        for r, num in enumerate(nums):
            summ += num
            while(summ >= target):
                res = min(res, r - l + 1)
                summ -= nums[l]
                l += 1
        
        return 0 if res == math.inf else res
        