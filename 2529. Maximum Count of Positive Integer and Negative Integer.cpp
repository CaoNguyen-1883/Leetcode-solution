#include"LeetCodeLibs.h"
class Solution {
public:
    int maximumCount(vector<int>& nums) {
        int l = 0, r = nums.size() - 1;

        while(l <= r){
            int m = (l + r) / 2;
            if(nums[m] >= 0) r = m - 1;
            else l = m + 1;
        }

        cout << l << endl;

        return 0;
    }
};