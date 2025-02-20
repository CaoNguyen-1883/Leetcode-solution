#include"LeetCodeLibs.h"
class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int countZero = 0, n = nums.size();  

        for(int i=0; i < n; ++i){
            if(nums[i] != 0){
                
                nums[countZero++] = nums[i];
            }
        }
        while(countZero < n) nums[countZero++] = 0;
    }
};