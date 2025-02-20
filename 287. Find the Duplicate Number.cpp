#include"LeetCodeLibs.h"
class Solution {
    public:
        int findDuplicate(vector<int>& nums) {
            // the array nums containing n + 1 integers and each integer is in the range  [1,n] inclusive,
            // There muse be at least one duplicate number and we don't need to consider the case of an infinity loop
    
            while(nums[0] != nums[nums[0]]) swap(nums[0], nums[nums[0]]);
    
            return nums[0];
        }
    };

//[1,3,4,2,2]
//[3,1,4,2,2]
//[2,1,4,3,2]
//[4,1,2,3,2]
//[2,1,2,3,4]

//[3,1,3,4,2]
//[4,1,3,3,2]
//[2,1,3,3,4]
//[3,1,2,3,4]
//