#include"LeetCodeLibs.h"

class Solution {
public:
    string reverseWords(string s) {
        string result;
        
        int fast = s.size() - 1;

        while(fast >= 0 && s[fast] == ' ') --fast;

        int slow = fast;

        while(fast >= 0){

            while(fast >= 0 && (
                s[fast] >= 'a' && s[fast] <= 'z' || 
                s[fast] >= 'A' && s[fast] <= 'Z' || 
                s[fast] >= '0' && s[fast] <='9'
            )) --fast; 

            result += s.substr(fast + 1, slow - fast) + ' ';

            while(fast >= 0 && s[fast] == ' ') --fast;
            slow = fast;
        }

        result.pop_back();

        return result;
    }
};


int main(){
    Solution s;
    cout << s.reverseWords("F0m n G wU");
}