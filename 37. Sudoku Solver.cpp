#include"LeetCodeLibs.h"

class Solution {
public:
    void solveSudoku(vector<vector<char>>& board) {
        solve(board, 0);
    }
private:
    bool rows[9][9] = {false};
    bool cols[9][9] = {false};
    bool brd[9][9] = {false};

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

};


class Solution2 {
public:
    void solveSudoku(vector<vector<char>>& board) { 
        bool rows[9][9] = {false};
        bool cols[9][9] = {false};
        bool boxes[9][9] = {false};
        vector<pair<int, int>> emptyCells;
        
        for(int i = 0; i < 9; ++i){
            for(int j = 0; j < 9; ++j){
                if(board[i][j] == '.'){
                    emptyCells.emplace_back(i, j);
                } else{
                    int value = board[i][j] - '0' - 1;
                    rows[i][value] = true;
                    cols[j][value] = true;
                    boxes[(i/3) * 3 + j/3][value] = true;
                }
            }
        }

        sort(emptyCells.begin(), emptyCells.end(), [&](const pair<int, int>& a, const pair<int, int>& b){
            return countChoices(a.first, a.second, rows, cols, boxes) < countChoices(b.first, b.second, rows, cols, boxes);
        });

        solve(board, emptyCells, rows, cols, boxes, 0);
    }
private:    
    int countChoices(int i, int j,  bool rows[9][9], bool cols[9][9], bool boxes[9][9]){
        int count = 0;
        int boxIndex = (i / 3) * 3 + j / 3;
        for (int num = 0; num < 9; ++num) {
            if (!rows[i][num] && !cols[j][num] && !boxes[boxIndex][num]) {
                ++count;
            }
        }
        return count;
    }

    bool solve(vector<vector<char>>& board, vector<pair<int, int>>& emptyCells, bool rows[9][9], bool cols[9][9], bool boxes[9][9], int index){
        if(index == emptyCells.size()) return true;

        int i = emptyCells[index].first;
        int j = emptyCells[index].second;
        int boxIndex = (i / 3) * 3 + j / 3;

        for(int num = 0; num < 9; ++num){
            if(!rows[i][num] && !cols[j][num] && !boxes[boxIndex][num]){
                board[i][j] = num + '1';
                rows[i][num] = cols[j][num] = boxes[boxIndex][num] = true; 

                if(solve(board, emptyCells, rows, cols, boxes, index + 1)) return true;

                board[i][j] = '.';
                rows[i][num] = cols[j][num] = boxes[boxIndex][num] = false;
            }
        }

        return false;
    }
};