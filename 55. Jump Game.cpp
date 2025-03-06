#include"LeetCodeLibs.h"

class Solution {
public:
    bool canJump(vector<int>& nums) {
        int n = nums.size();
        int maxDistant = nums[0];
        int i = 0;
        for(; i < n && i <= maxDistant; ++i){
            if(maxDistant < i + nums[i]) maxDistant = i + nums[i];
        }

        return i == n;
    }
};