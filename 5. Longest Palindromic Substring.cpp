#include"LeetCodeLibs.h"

class Solution {
public:
    string longestPalindrome(string s) {
        string res = "";

        for(int i = 0; i < s.size();){
            int l = i;
            int r = i;
            while(r < s.size() - 1 && s[r] == s[r + 1]) ++r;
            i = r + 1;

            while(l > 0 && r < s.size() - 1 && s[l - 1] == s[r + 1]){
                --l;
                ++r;
            }

            if(r - l + 1 > res.size()){
                res = s.substr(l, r - l + 1);
            }
        }

        return res;
    }
};