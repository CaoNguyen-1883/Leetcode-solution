#include"LeetCodeLibs.h"

class Solution {
public:
    int magicalString(int n) {
        string s = " 122";
        for(int i = 3; i <= n; ++i){
            if(i % 2 == 1)
                s.append(s[i] - '0', '1');
            else   
                s.append(s[i] - '0', '2');
        }

        return count(s.begin(), s.begin() + n + 1, '1');
    }

    int magicalString(int n){
        if(n <= 3) return 1;
        int a[n];
        a[0] = 1;
        a[1] = 2;
        
        for(int i = 1, j = 1; j < n; ++i, ++j){
            a[j] = i & 1 ? 2 : 1;
            if(a[i] == 2 && ++j < n)
                a[j] == a[j - 1];
        }

        int res = 0;
        
        return count(a, a + n, 1);
    }    
}; 