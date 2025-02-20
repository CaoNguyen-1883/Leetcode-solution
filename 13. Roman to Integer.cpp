#include"LeetCodeLibs.h"

class Solution {
public:
    int romanToInt(string s) {           
        int sum = 0, prev = 0;

        vector<int> romans(128);
        romans['I'] = 1;
        romans['V'] = 5;
        romans['X'] = 10;
        romans['L'] = 50;
        romans['C'] = 100;
        romans['D'] = 500;
        romans['M'] = 1000;

        for(int i = s.size() - 1; i >= 0; --i){
            int curr = romans[s[i]];
            if(curr < prev){
                sum -= curr;
            }else{
                sum += curr;
            }
            prev = curr;
        }
        return sum;
    }
};