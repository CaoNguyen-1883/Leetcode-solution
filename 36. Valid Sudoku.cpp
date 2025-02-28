#include"LeetCodeLibs.h"

class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        bool rows[9][9] = {false};
        bool cols[9][9] = {false};
        bool brd[9][9] = {false};



        for(int i = 0; i < 9; ++i){
            for(int j = 0; j < 9; ++j){
                char c = board[i][j];
                if(c  != '.'){
                    int n = c  - '0' - 1;
                    int index = i/3 * 3 + j/3;

                    if(rows[i][n] || cols[j][n] || brd[index][n]) return false;
      

                    rows[i][n] = true;
                    cols[j][n] = true;
                    brd[index][n] = true;
                }
            }
        }

        return true;
    }
};