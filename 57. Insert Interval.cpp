#include"LeetCodeLibs.h"
class Solution1 {
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        vector<vector<int>> res;
        int l = 0;
        int n = intervals.size();
        int r = n - 1;

        while(l < r){
            int m = (l + r) / 2;
            if(intervals[m][0] < newInterval[0]) l = m + 1;
            else r = m - 1;
        }

        intervals.insert(intervals.begin() + l, newInterval);

        for(auto& i : intervals){
            if(res.empty() || res.back()[1] < i[0]){
                res.push_back(i);
            } else{
                res.back()[1] = max(res.back()[1], i[1]);
            }
        }

        return res;
    }
};

class Solution {
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        vector<vector<int>> res;
        int l = 0;
        int n = intervals.size();
        int r = n - 1;

        while(l <= r){
            int m = (l + r) / 2;
            if(intervals[m][0] < newInterval[0]) l = m + 1;
            else r = m - 1;
        }

        intervals.insert(intervals.begin() + l, newInterval);


        for(auto& i : intervals){
            if(res.empty() || res.back()[1] < i[0]){
                res.push_back(i);
            } else{
                res.back()[1] = max(res.back()[1], i[1]);
            }
        }
        return res;
    }
};