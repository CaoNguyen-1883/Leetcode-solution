#include"LeetCodeLibs.h"

class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        if(matrix.empty()) return {};

        int left = 0, right = matrix[0].size();
        int top = 0, bot = matrix.size();
        int n = right;
        int m = bot;
        vector<int> res;

        while(res.size() < m*n){
            for(int i = left; i < right && res.size() < m*n; ++i){
                res.push_back(matrix[top][i]);
            }
    
            
            for(int i = top; i < bot  && res.size() < m*n; ++i){
                res.push_back(matrix[i][right]);
            }
            
            for(int i = right; i > left  && res.size() < m*n; --i){
                res.push_back(matrix[bot][i]);
            }
           
            for(int i = bot; i > top  && res.size() < m*n; --i){
                res.push_back(matrix[i][left]);
            }
            ++top;
            ++left;
            --right;
            --bot;
        }

        
        return res;
    }
};