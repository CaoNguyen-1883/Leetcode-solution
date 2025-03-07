#include"LeetCodeLibs.h"

class Solution {
public:
    int jump(vector<int>& nums) {
        int n = nums.size();
        int res = 0;
        int maxDistant =0;
        int end = 0;
        
        for(int i = 0; i < n -1; ++i){
            if(maxDistant < i + nums[i]){
                maxDistant = i + nums[i];
            }

            if(maxDistant >= n - 1){
                ++res;
                break;
            }

            if(i == end){
                ++res;
                end = maxDistant;
            }
        }
 
        return res;
    }
};


struct ListNode{
    int val;
    ListNode* next;

};

