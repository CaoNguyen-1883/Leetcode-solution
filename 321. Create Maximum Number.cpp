#include"LeetCodeLibs.h"

class Solution {
public:
    vector<int> maxNumber(vector<int>& nums1, vector<int>& nums2, int k) {
        vector<int> v1(nums1);
        vector<int> v2(nums2);
        vector<int> res(k);
        sort(v1.begin(), v1.end(), [](int a, int b){return a > b;});
        sort(v2.begin(), v2.end(), [](int a, int b){return a > b;});
        int i1 = 0, i2 = 0, i = 0;

        while(i1 < nums1.size() && i2 < nums2.size() && --k){
            if(nums1[i1] > nums2[i2]) res[i++] = nums1[i1++];
            else res[i++] = nums2[i2++];
        }

        while(i1 <  nums1.size() && --k) res[i++] = nums1[i1++];
        while(i2 < nums2.size() && --k) res[i++] = nums2[i2++];

        return res;
    }
};

