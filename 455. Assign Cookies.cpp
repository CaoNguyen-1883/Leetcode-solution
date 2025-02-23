#include"LeetCodeLibs.h"

class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        int res = 0, n = g.size();
        sort(g.begin(), g.end());
        sort(s.begin(), s.end());

        for(int& i : s){
            if(res < n && g[res] <= i) ++res;
        }

        return res;
    }
};