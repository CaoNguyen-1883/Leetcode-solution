class Solution:
    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        if not matrix:
            return 0
        res = 0
        hist = [0]*len(matrix[0])
        for row in matrix:
            for i in range(len(row)):
                hist[i] = 0 if row[i] == 0 else hist[i] + 1
            res = max(res, self.maxReact(hist))
        return res
    
    def maxReact(self, heights: List[int]) -> int:
        res = 0
        stack = []

        for i in range(len(heights) + 1):
            while stack and (i == len(heights) or heights[stack[-1]] >= heights[i]):
                h = heights[stack.pop()]
                w = i if not stack else i - stack[-1] - 1
                res = max(res, h * w)

            stack.append(i)

        return res