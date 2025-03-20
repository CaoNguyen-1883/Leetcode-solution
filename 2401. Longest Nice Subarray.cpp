#include"LeetCodeLibs.h"

class Solution {
public:
    int longestNiceSubarray(vector<int>& nums) {
        int res = 0;
        int used = 0;
        int n = nums.size();

        for(int l = 0, r = 0; l < n && r < n; ++r){
            while(used & nums[r])
                used ^= nums[l++];

            used |= nums[r];
            res = max(res, r - l  + 1);
        }
        

        return res;
    }
};