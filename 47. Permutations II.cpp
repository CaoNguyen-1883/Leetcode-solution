#include"LeetCodeLibs.h"



// Input: nums = [1,1,2]
// Output:
// [[1,1,2],
//  [1,2,1],
//  [2,1,1]]
class Solution {
public:
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        vector<vector<int>> res;
        vector<bool> used(nums.size());
        vector<int> path;
        sort(nums.begin(), nums.end());
    
        solve(res, nums, path, used);
        
        return res;
    }


    void solve(vector<vector<int>>& res, vector<int>& nums, vector<int>& path, vector<bool>& used){
        if(path.size() == nums.size()){
            res.push_back(path);
            return;
        }

        for(int i = 0; i < nums.size(); ++i){
            if (used[i]) continue;
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            path.push_back(nums[i]);
            solve(res, nums, path, used);

            path.pop_back();
            used[i] = false;
        }
    }
    
};
