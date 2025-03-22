#include"LeetCodeLibs.h"

class Solution {
public:
    bool search(vector<int>& nums, int target) {
        int l = 0; int r = nums.size() - 1;
        int n = r;
        while(l < r){
            int m = (l + r) / 2;
            if(nums[m] == target) return true;
            else if(target < nums[m]){
                if(nums[n] <= nums[m]) l = m + 1;
                else r = m - 1;
            } else{
                if(nums[n] <= nums[m]) r = m - 1;
                else l = m + 1;
            }
        }

        return false;
    }
};