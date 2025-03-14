#include"LeetCodeLibs.h"
class Solution1 {
public:
    int findKthLargest(vector<int>& nums, int k) {
        sort(nums.begin(), nums.end());


        return nums[nums.size() - k];
    }   
};

class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int, vector<int>, less<int>> maxHeap;

        for(int& i : nums){
            maxHeap.push(i);
        }

        while(--k) maxHeap.pop();

        return maxHeap.top();
    }
};          