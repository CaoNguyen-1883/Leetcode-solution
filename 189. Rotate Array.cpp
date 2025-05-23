#include"LeetCodeLibs.h"

class Solution {
public:
    void rotate(vector<int>& nums, int k) {   
        int n = nums.size();
        k %= n;
        reverse(nums.begin(), nums.end());
        reverse(nums.begin(), nums.begin() + k);
        reverse(nums.begin() + k, nums.end());
    }
};

//[1,2,3,4,5,6,7]
//[7,6,5,4,3,2,1]
//[5,6,7,1,2,3,4];


