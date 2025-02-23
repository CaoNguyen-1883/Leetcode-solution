#include"LeetCodeLibs.h"

class Solution {
public:
    int compress(vector<char>& chars) {
        int res = 0;
        int n = chars.size();
        int i = 0;
        while(i < n){
            int j = i + 1;

            while(j < n && chars[i] == chars[j]) ++j;
            chars[res++] = chars[i];
            if(j - i > 1){
                int x = j - i;
                int l = res;
                while( x > 0){
                    chars[res++] = x%10 + '0';
                    x /= 10;
                }
                int r = res - 1;
                while(l < r) swap(chars[l++], chars[r--]);
            }
            i = j;
        }

        return res;
    }
};