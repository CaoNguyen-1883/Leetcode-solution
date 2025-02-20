#include"LeetCodeLibs.h"

class Solution {
private:
    int n;
    vector<vector<int>> res;
public:
    void backTrack(vector<int>& path, int index){
        if(index == n - 1) res.push_back(path);
        else{
            for(int i = index; i < n; ++i){
                swap(path[i], path[index]);
                backTrack(path, i + 1);
                swap(path[i], path[index]);
            }
        }-
    }

    vector<vector<int>> permute(vector<int>& nums) {
        n = nums.size();
        backTrack(nums, 0);
        return res;
    }
};


// [1, 2, 3]
//[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 0 1 2   0 2 1   1 0 2   1 2 0   2 0 1  2 1 0