#include"LeetCodeLibs.h"

class Solution {
public:
    string multiply(string num1, string num2) {
        string res = "";
        int n = num1.size();
        int m = num2.size();
        vector<int> v(n + m);   
        
        for(int i = n - 1; i >= 0; --i){
            for(int j = m - 1; j >= 0; --j){
                int l1 = i + j, l2 = i + j + 1;
                int mul = v[l2] + ((num1[i] - '0') * (num2[j] - '0'));
                v[l1] += mul / 10;
                v[l2] = mul % 10;
            }
        }
        int i = 0;
        while(i < v.size() && v[i] == 0) ++i;

        for(; i < v.size(); ++i) res += v[i] + '0';

        return res.length() ==  0 ? "0" : res;
    }
};
