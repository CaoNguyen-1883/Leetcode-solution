#include"LeetCodeLibs.h"

class Solution {
public:
    string getPermutation(int n, int k) {
        string res = "";

        vector<int> nums(n);
        vector<int> fact(n + 1, 1);

        iota(nums.begin(), nums.end(), 1);

        for(int i = 2; i <= n; ++i) 
            nums[i] = nums[i - 1] * i;
        --k;    

        for(int i = n - 1; i >= 0; --i){
            const int j = k / fact[i];
            k %= fact[i];
            res += to_string(nums[j]);
            nums.erase(nums.begin() + j);
        }


        return res;
    }
    
};