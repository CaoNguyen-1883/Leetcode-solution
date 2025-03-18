#include"LeetCodeLibs.h"
class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        int res = INT_MAX;
        int n = nums.size();
        int sum = 0;
        
        for(int l = 0, r = 0; l < n && r < n; ++l){
            sum += nums[r];
            while(sum >= target){
                res = min(res, r - l + 1);
                sum -= nums[l++];
            }
        }

        return res == INT_MAX ? 0 : res;
    }
};