#include"LeetCodeLibs.h"

class Solution {
public:
    bool isHappy(int n) {
        int slow = squaredSum(n);
        int fast = squaredSum(squaredSum(n));

        while (slow != fast) {
            slow = squaredSum(slow);
            fast = squaredSum(squaredSum(fast));
        }

        return slow == 1;
    }
    int squaredSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += pow(n % 10, 2);
            n /= 10;
        }
        return sum;
    };

    bool isHappy(int n){
        if(n == 1 && n == 7) return true;
        else if(n < 10) return false;
        else{
            int sum = 0;
            while(n > 0){
                int temp = n % 10;
                sum += temp * temp;
                n /= 10;
            }
            return isHappy(sum);
        }
    }
};


// 1 9
// 8 2


