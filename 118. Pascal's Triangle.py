class Solution(object):
    def generate(self, numRows):
        """
        :type numRows: int
        :rtype: List[List[int]]
        """
        res = []
        
        for i in range(numRows):
            res.append([1]*(i + 1))

        for i in range(2, numRows):
            for j in range(1, len(res[i]) - 1):
                res[i][j] = res[i - 1][j - 1] + res[i - 1][j]

        return res