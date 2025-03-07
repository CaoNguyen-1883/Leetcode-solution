class Solution:
    def jump(self, nums: List[int]) -> int:
        end = 0
        maxDistant = 0
        n = len(nums)
        res = 0

        for i in range(n - 1):
            if(maxDistant < nums[i] + i):
                maxDistant = nums[i] + i
            
            if(maxDistant >= n - 1):
                res += 1
                break
            
            if(i == end):
                res += 1
                end = maxDistant

        return res
    
