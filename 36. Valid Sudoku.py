class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        rows = [[False] * 9 for _ in range(9)]
        cols = [[False] * 9 for _ in range(9)]
        boxes = [[False] * 9 for _ in range(9)]

        for i in range(9):
            for j in range(9):
                c = board[i][j]
                if c != '.':  
                    num = int(c) - 1 
                    box_index = (i // 3) * 3 + (j // 3)  

                    if rows[i][num] or cols[j][num] or boxes[box_index][num]:
                        return False  

                    rows[i][num] = True
                    cols[j][num] = True
                    boxes[box_index][num] = True
        return True  