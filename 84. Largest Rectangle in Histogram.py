
class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        stack = []
        left = [-1] * len(heights)
        right = [len(heights)] * len(heights)
        res = 0
        for i, num in enumerate(heights):
            while stack and heights[stack[-1]] >= num:
                right[stack[-1]] = i
                stack.pop()
            if stack:
                left[i] = stack[-1]
            stack.append(i)

        for i in range(len(heights)):
            res = max(res, heights[i] * (right[i] - left[i] - 1))
        
        return res