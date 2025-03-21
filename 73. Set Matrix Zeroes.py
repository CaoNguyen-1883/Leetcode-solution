class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        
        m = len(matrix)
        n = len(matrix[0])

        rows = [False]*n
        cols = [False]*m

        for i in range(m):
            for j in range(n):
                if(matrix[i][j] == 0):
                    rows[j] = True
                    cols[i] = True
        
        for i in range(len(rows)):
            if(rows[i] == True):
                for j in range(m):
                    matrix[j][i] = 0
            
        
        for i in range(len(cols)):
            if(cols[i] == True):
                for j in range(n):
                    matrix[i][j] = 0