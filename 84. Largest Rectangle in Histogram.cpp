#include"LeetCodeLibs.h"
class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        int res = 0, n = heights.size();
        stack<int> stk;
        vector<int> left(n, -1);
        vector<int> right(n, n);
        for (int i = 0; i < n; ++i) {
            while (!stk.empty() && heights[stk.top()] >= heights[i]) {
                right[stk.top()] = i;
                stk.pop();
            }
            if (!stk.empty()) left[i] = stk.top();
            stk.push(i);
        }
        for (int i = 0; i < n; ++i)
            res = max(res, heights[i] * (right[i] - left[i] - 1));
        return res;
    }
};
class Solution2 {
    public:
        vector<int> prevSmallerElements(vector<int>& heights){
            int n = heights.size();
            vector<int> stack;
            vector<int> smallers(n);
            
            for(int i = 0; i < n; ++i){
                while(!stack.empty() && heights[stack.back()] >= heights[i]) stack.pop_back();
                smallers[i] = stack.empty() ? -1 : stack.back();
                stack.push_back(i);
            }
                
            return smallers;
        }
    
        vector<int> nextSmallerElements(vector<int>& heights){
            int n = heights.size();
            vector<int> stack;
            vector<int> smallers(n);
            for(int i = n - 1; i >= 0; --i){
                while(!stack.empty() && heights[stack.back()] >= heights[i]) stack.pop_back();
                smallers[i] = stack.empty() ? n : stack.back();
                stack.push_back(i);
            }
                
            return smallers;
        }
    
        int largestRectangleArea(vector<int>& heights) {
            int res = 0;
            vector<int> prevs = prevSmallerElements(heights);
            vector<int> nexts = nextSmallerElements(heights);
            for(int i : prevs) cout << i << " ";
            cout << endl;
            for(int i : nexts) cout << i << " ";
    
            for(int i = 0; i < heights.size(); ++i){
                res = max(res, heights[i]*(nexts[i] - prevs[i] - 1));
            }
    
            return res;
        }
    };