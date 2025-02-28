/**
 * @param {character[][]} board
 * @return {boolean}
 */
var isValidSudoku = function(board) {

        const rows = Array.from({ length: 9 }, () => Array(9).fill(false));
        const cols = Array.from({ length: 9 }, () => Array(9).fill(false));
        const boxes = Array.from({ length: 9 }, () => Array(9).fill(false));

        for (let i = 0; i < 9; i++) {
            for (let j = 0; j < 9; j++) {
                const c = board[i][j];
                if (c !== '.') { 
                    const num = parseInt(c) - 1; 
                    const boxIndex = Math.floor(i / 3) * 3 + Math.floor(j / 3); 

                    if (rows[i][num] || cols[j][num] || boxes[boxIndex][num]) {
                        return false; 
                    }
                    
                    rows[i][num] = true;
                    cols[j][num] = true;
                    boxes[boxIndex][num] = true;
                }
            }
        }
        return true; 
    
};