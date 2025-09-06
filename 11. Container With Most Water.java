class Solution {
    public int maxArea(int[] height) {
        int max = 0;

        int l = 0, r = height.length - 1;

        while(l < r){
            int min = Math.min(height[l], height[r]);
            max = Math.max(max, (r - l) * min);

            while(l < r && height[l] <= min) l++;
            while(l < r && height[l] <= min) r--;
        }


        return max;
    }
}