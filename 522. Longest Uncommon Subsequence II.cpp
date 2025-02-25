#include"LeetCodeLibs.h"

class Solution {
public:
    int findLUSlength(vector<string>& strs) {
        for(string& s : strs) sort(s.begin(), s.end());

        sort(strs.begin(), strs.end(), [](string a, string b){
            return a.size() < b.size();
        });

        for(string s : strs) cout << s << endl;

        return -1;
    }
};