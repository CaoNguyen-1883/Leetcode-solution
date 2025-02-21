#include"LeetCodeLibs.h"

class Solution {
public:
    string reverseVowels(string s) {
        int left = 0, right = s.size() - 1;
        char v[128] = {0};
        v['a'] = true; 
        v['e'] = true; 
        v['i'] = true; 
        v['o'] = true; 
        v['u'] = true; 
        v['A'] = true; 
        v['E'] = true; 
        v['I'] = true; 
        v['O'] = true; 
        v['U'] = true; 

        while(left < right){
            while(!v[s[left]] && left < right) ++left;
            while(!v[s[right]] && left < right) --right;
            swap(s[left++], s[right--]);
        }

        return s;
    }
};