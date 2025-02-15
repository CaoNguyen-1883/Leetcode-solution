#include"LeetCodeLibs.h"

class Solution {   
public:
    int compareVersion(string version1, string version2) {
        istringstream iss1(version1);
        istringstream iss2(version2);
        int v1, v2;
        char dotChar;

        while(bool(iss1 >> v1) + bool(iss2 >> v2)){
            if(v1 < v2) return -1;
            if(v1 > v2) return 1;

            iss1 >> dotChar;
            iss2 >> dotChar;
            v1 = 0;
            v2 = 0;
        }

        return 0;
    }
    int compareVersion(string version1, string version2){
        int ver1 = 0, ver2 = 0;
        int n = version1.size(), m = version2.size();

        for(int i = 0, j = 0; i < n || j < m; ++i, ++j){

            while(i < n && version1[i] != '.'){
                ver1 = ver1*10 + (version1[i] - '0');
            }

            while(j < m && version2[j] != '.'){
                ver2 = ver2*10 + (version2[j] - '0');
            }
            
            if(ver1 < ver2) return -1;
            if(ver1 > ver2) return 1;
            ver1 = 0;
            ver2 = 0;
        }

        return 0;
    }
};