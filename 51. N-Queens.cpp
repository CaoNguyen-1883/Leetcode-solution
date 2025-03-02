#include"LeetCodeLibs.h"

class Solution {
public:
    vector<vector<string>> solveNQueens(int n) {
        vector<vector<string>> res;

        vector<bool> cols(n);
        vector<bool> diag1(2*n-1);
        vector<bool> diag2(n*2-1);
        vector<string> board(n, string(n, '.'));

        solve(res, board,cols, diag1, diag2, 0, n);
        return res;
    }   

    void solve(vector<vector<string>>& res, vector<string>& board, vector<bool>& cols, vector<bool>& diag1, vector<bool>& diag2, int i, int n){
        if(i == n){
            res.push_back(board);
            return ;
        }
        for(int j = 0; j < n; ++j){
            if(cols[j] || diag1[i + j] || diag2[j - i + n - 1]) continue;

            cols[j] = diag1[i + j] = diag2[j - i + n - 1] = true;
            board[i][j] = 'Q';
            solve(res, board, cols, diag1, diag2, i + 1, n);
            cols[j] = diag1[i + j] = diag2[j - i + n - 1] = false;
            board[i][j] = '.';

        }
    }
};  