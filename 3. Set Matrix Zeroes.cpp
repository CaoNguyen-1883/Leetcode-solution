#include"LeetCodeLibs.h"

class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
        int m = matrix.size();
        int n = matrix[0].size();
        vector<bool> rows(n);
        vector<bool> cols(m);

        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(!matrix[i][j]){
                    rows[j] = true;
                    cols[i] = true;
                }
            }
        }
        for(int i = 0; i < rows.size(); ++i){
            if(rows[i]){
                for(int j = 0; j < m; ++j){
                    matrix[j][i] = 0;
                }
            }
        }
        for(int i = 0; i < cols.size(); ++i){
            if(cols[i]){
                for(int j = 0; j < m; ++j){
                    matrix[i][j] = 0;
                }
            }
        }
    }
};