#include"LeetCodeLibs.h"

class Solution2 {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        if(matrix.empty()) return {};

        int left = 0;
        int right = matrix[0].size() - 1;
        int top = 0;
        int bot = matrix.size() - 1;
        vector<int> res;

        while(left <= right && bot <= top){
            for(int i = left; i <= right; ++i) res.push_back(matrix[top][i]);
            ++top;
            
            for(int i = top; i <= bot; ++i) res.push_back(matrix[i][right]);
            --right;

            for(int i = right; i >= left; --i) res.push_back(matrix[bot][i]);
            --bot;

            for(int i = bot; i >= top; --i) res.push_back(matrix[i][left]);
            ++left;
        }
        
        return res;
    }
};

class Solution {
    public:
     vector<int> spiralOrder(vector<vector<int>>& matrix) {
       if (matrix.empty())
         return {};
   
       const int m = matrix.size();
       const int n = matrix[0].size();
       vector<int> ans;
       int r1 = 0;
       int c1 = 0;
       int r2 = m - 1;
       int c2 = n - 1;
   
       // Repeatedly add matrix[r1..r2][c1..c2] to `ans`.
       while (ans.size() < m * n) {
         for (int j = c1; j <= c2 && ans.size() < m * n; ++j)
           ans.push_back(matrix[r1][j]);
         for (int i = r1 + 1; i <= r2 - 1 && ans.size() < m * n; ++i)
           ans.push_back(matrix[i][c2]);
         for (int j = c2; j >= c1 && ans.size() < m * n; --j)
           ans.push_back(matrix[r2][j]);
         for (int i = r2 - 1; i >= r1 + 1 && ans.size() < m * n; --i)
           ans.push_back(matrix[i][c1]);
         ++r1, ++c1, --r2, --c2;
       }
   
       return ans;
     }
   };