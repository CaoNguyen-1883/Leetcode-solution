
import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack();
        int n = heights.length;
        int left[] = new int[n];
        int right[] = new int[n];
        for (int i = 0; i < n; ++i) left[i] = -1;
        for (int i = 0; i < n; ++i) right[i] = n;
        int res = 0;
        for(int i = 0; i < n; ++i){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                right[stack.peek()] = i;
                stack.pop();
            }
            if(!stack.isEmpty()) left[i] = stack.peek();
            stack.push(i);
        }
        for(int i = 0; i < n; ++i){
            res = Math.max(res, heights[i] * (right[i] - left[i] - 1));
        }
        return res;
    } 
}