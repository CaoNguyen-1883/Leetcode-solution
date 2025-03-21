#include"LeetCodeLibs.h"

class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end());
        int i1 = 0, i2 = 0;

        vector<int> v;
        vector<int> res;
    
        while(i1 < nums1.size() && i2 < nums2.size()){
            if(nums1[i1] < nums2[i2]){ ++i1;}
            else if(nums1[i1] > nums2[i2]) ++i2;
            else {
                if(v.back() != nums1[i1])v.push_back(nums1[i1]);
                ++i1; ++i2;
            }

        }
        return v;
    }
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        vector<int> res;
        unordered_set<int>  st(nums1.begin(), nums1.end());

        for(int& i : nums2){
            if(st.erase(i))
                res.push_back(i);
        }
        return res;
    }
};