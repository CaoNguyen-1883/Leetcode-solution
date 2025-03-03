#include"LeetCodeLibs.h"

class Solution {
public:
    string getPermutation(int n, int k) {
        string s = "";
        
        for(int i = 0; i < n; ++i) s += i + '1';

        string res = "";
        
        solve(res, s, string(""), vector<bool>(n), k, 0);

        return res;
    }

    void solve(string& res, string& s, string& path, vector<bool>& used, int k, int count){
        if(path.size() == s.size()){
            ++count;  
            cout << count << endl;
            if(count == k) {
                res = path;
            }
            return;
        }

        for(int i = 0; i < s.size(); ++i){
            if(used[i]) continue;
            
            path.push_back(s[i]);
            solve(res, s, path, used, k, count);
            path.pop_back();
        }
    }
};