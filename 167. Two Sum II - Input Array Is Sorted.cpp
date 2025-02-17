#include"LeetCodeLibs.h"

class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        vector<int> res;
        int left = 0, right = numbers.size();
        
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum == target) return {left, right};
            else if(sum > target) --right;
            else ++left;
        }

        return {};
    }
};