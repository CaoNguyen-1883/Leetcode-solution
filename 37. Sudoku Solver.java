
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Solution {
    public void solveSudoku(char[][] board) {
        boolean rows[][] = new boolean[9][9];
        boolean cols[][] = new boolean[9][9];
        boolean boxes[][] = new boolean[9][9];
        List<int[]> emptyCells = new ArrayList<>();

        for(int i = 0; i  < 9; ++i){
            for(int j = 0; j < 9; ++j){
                if(board[i][j] == '.'){
                    emptyCells.add(new int[]{i, j});
                } else{
                    int val = board[i][j] - '1';
                    rows[i][val] = true;
                    cols[j][val] = true;
                    boxes[i / 3 * 3 + j /3][val] = true;
                }
            }
        }
        emptyCells.sort((a, b) -> countChoices(a[0], a[1], rows, cols, boxes) - countChoices(b[0], b[1], rows, cols, boxes));

        solve(board, emptyCells, rows, cols, boxes, 0);
    }

    public boolean solve(char[][] board, List<int[]> emptyCells,  boolean rows[][], boolean cols[][], boolean boxes[][], int index){
        if(index == emptyCells.size()) return true;

        int i = emptyCells.get(index)[0];
        int j = emptyCells.get(index)[1];
        int boxIndex = (i / 3) * 3 + j / 3;

        for(int val = 0; val < 9; ++val){
            if(!rows[i][val] && !cols[j][val] && !boxes[boxIndex][val]){
                board[i][j] = (char)(val + '1');
                rows[i][val] = cols[j][val] = boxes[boxIndex][val] = true;

                if(solve(board, emptyCells, rows, cols, boxes, index + 1)) return true;

                board[i][j] = '.';
                rows[i][val] = cols[j][val] = boxes[boxIndex][val] = false;
            }
        }

        return false;
    }
    public int countChoices(int row, int col, boolean rows[][], boolean cols[][], boolean boxes[][]){
        int count = 0;
        int boxIndex = row / 3 * 3 + col / 3;
        for(int i = 0; i < 9; ++i){
            if(!rows[row][i] && !cols[col][i] && !boxes[boxIndex][i]) ++count;
        }
        return count;
    }
}