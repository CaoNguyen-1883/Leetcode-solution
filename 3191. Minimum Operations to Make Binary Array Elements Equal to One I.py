class Solution:
    def minOperations(self, nums: List[int]) -> int:
        n = len(nums)
        count = 0

        for i, num in enumerate(nums):
            if num == 0:
                if i + 2 >= n:
                    return - 1
                count += 1
                nums[i + 1] = 1 - nums[i + 1]
                nums[i + 2] = 1 - nums[i + 2]

        return count