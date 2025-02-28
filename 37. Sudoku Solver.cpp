#include"LeetCodeLibs.h"

class Solution {
public:

    bool solve(vector<vector<char>>& board, int n){
        if(n == 81) return true;

        int i = n / 9;
        int j = n % 9; 

        if(board[i][j] != '.') return solve(board, n + 1);
        
        for(char c = '1'; c <= '9'; ++c){
            if(isValid(board, i, j, c)){
                board[i][j] = c;
                if(solve(board, n + 1)) return true;
                board[i][j] = '.';
            }
        }
        return false;
    }

    bool isValid(const vector<vector<char>>& board, const int& row, const int& col, const char& c){
        for(int i = 0; i < 9; ++i){
            if(
                board[i][col] ==c || 
                board[row][i] == c ||
                board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i % 3] == c
            ) 
                return false;
        }   

        return true;
    }
    void solveSudoku(vector<vector<char>>& board) {
        solve(board, 0);
    }
};