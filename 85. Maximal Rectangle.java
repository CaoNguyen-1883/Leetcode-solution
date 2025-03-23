
import java.util.Stack;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;

        int res = 0;
        int[] hist = new int[matrix[0].length];

        for(char[] row : matrix){
            for(int i = 0; i < row.length; ++i){
                hist[i] = row[i] == '0' ? 0 : hist[i] + 1;
            }
            res = Math.max(res, largestRect(hist));
        }
        return res;
    }
    public int largestRect(int[] heights){
        int res = 0;
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i <= heights.length; ++i){    
            while(!stk.isEmpty() && (i == heights.length || heights[stk.peek()] >= heights[i])){
                int h = heights[stk.pop()];
                int w = stk.isEmpty() ? i : i - stk.peek() - 1;
                res = Math.max(res, h * w);
            }
            stk.push(i);
        }
        
        return res;
    }
}