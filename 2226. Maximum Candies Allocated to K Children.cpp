#include"LeetCodeLibs.h"

class Solution {
public:
    int maximumCandies(vector<int>& candies, long long k) {
        int minCandies = 0, maxCandies = 1e7;

        while (minCandies < maxCandies) {
            int mid = (minCandies + maxCandies + 1) >> 1;
            long long childCount = 0;

            for (int candiesInPile : candies) {
                childCount += candiesInPile / mid;
            }
            if (childCount >= k) {
                minCandies = mid;
            } else {
                maxCandies = mid - 1;
            }
        }
        return minCandies;
    }
};

// 4 5 7; k = 4; 1 1 2