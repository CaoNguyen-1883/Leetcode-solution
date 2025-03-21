#include"LeetCodeLibs.h"

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int m = matrix.size();
        int n = matrix[0].size();
        int l = 0, r = m * n - 1;

        while(l < r){
            int mid = (l + r) / 2;
            int i = mid / m;
            int j = m % n;
            if(target == matrix[i][j]) return true;
            else if (target < matrix[i][j]) r = m - 1;
            else l = m + 1;
        }


        return false;
    }
}; 