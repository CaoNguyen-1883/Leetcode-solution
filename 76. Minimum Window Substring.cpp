#include"LeetCodeLibs.h"

class Solution {
public:
    string minWindow(string s, string t) {
        string res = "";
        int n = s.length(), m = t.length();        
        int begin = - 1;
        int offset = n + 1;

        int a[128] = {0};

        for(char& c : t){
            ++a[c];
        }

        for(int l = 0, r = 0; r < n; ++r){
            if(--a[s[r]] >= 0) --m;

            while(m == 0){
                if(r - l + 1 < offset){
                    begin = l;
                    offset = r - l + 1;
                }

                if(++a[s[l++]] > 0) ++m;
            }
        }
        


        return begin == -1 ? "" : s.substr(begin, offset);

    }
};