#include"LeetCodeLibs.h"

class Solution {
public:
    bool isSubsequence(string s, string t) {
        int i = 0, j = 0, n = s.length(), m = t.length();
        
        while(j < m && i < n){
            if(s[i] == t[j]) ++i;
            ++j;
        }

        return i == n;
    }
};