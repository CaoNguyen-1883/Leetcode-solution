#include"LeetCodeLibs.h"

class Solution {
public:
    string simplifyPath(string path) {
        vector<string> stack;
        string res;
        istringstream iss(path);

        for(string dir; getline(iss, dir, '/');){
            if(dir.empty() || dir == ".") continue;
            if(dir == ".."){
                if(!stack.empty()) stack.pop_back();
            } else{
                stack.push_back(dir);
            }
        }

        for(string& s : stack){
            res += "/" + s;
        }
        return res.empty() ? "/" : res;
    }
};