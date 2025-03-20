#include"LeetCodeLibs.h"

class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        int n = nums.size();
        vector<int> res;
        priority_queue<int, vector<int>, less<int>> maxHeap;

        for(int i = 0; i < k; ++i) maxHeap.push(nums[i]);
        res.push_back(maxHeap.top());

        for(int l = 0, r = k; r < n; ++r){
            maxHeap.
        }

        return res;
    }
};