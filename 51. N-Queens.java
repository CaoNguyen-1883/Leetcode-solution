import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        boolean cols[] = new boolean[n];
        boolean diag1[] = new boolean[2*n - 1];
        boolean diag2[] = new boolean[2*n - 1];
        char board[][] = new char[n][n];

        for(int i = 0; i < n; ++i) Arrays.fill(board[i], '.');

        solve(res, board, cols, diag1, diag2, n, 0);
        return res;
    }

    public void solve(List<List<String>> res, char board[][], boolean cols[], boolean diag1[], boolean diag2[], int n, int i){
        if(i == n){
            res.add(construct(board));
        } else{
            for(int j = 0; j < n; ++j){
                if(cols[j] || diag1[i + j] || diag2[j - i + n - 1]) continue;

                cols[j] = diag1[i + j] = diag2[j - i + n - 1] = true;
                board[i][j] = 'Q';
                solve(res, board, cols, diag1, diag2, n, i + 1);

                cols[j] = diag1[i + j] = diag2[j - i + n - 1] = false;
                board[i][j] = '.';
            }
        }
    }
    private List<String> construct(char[][] board) {
        List<String> listBoard = new ArrayList<>();
        for (int i = 0; i < board.length; ++i)
            listBoard.add(String.valueOf(board[i]));
        return listBoard;
    }
}