#include"LeetCodeLibs.h"

class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        unordered_set<string> res;
        unordered_set<string_view> seen;
        const string_view sv(s);

        int n = s.size();

        for(int i = 0; i < n - 10; i += 10){
            if(seen.count(sv.substr(i, 10)))
                res.insert(s.substr(i, 10));
            seen.insert(sv.substr(i, 10));
        }
    
        return {res.begin(), res.end()};
    }
};