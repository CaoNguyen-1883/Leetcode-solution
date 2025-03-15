
import java.util.Arrays;

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1) return intervals;

        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[][] res = new int[n][];

        res[0] = intervals[0];
        int j = 0;

        for(int i = 1; i < n; ++i){
            if(res[j][1] < intervals[i][0]){
                ++j;
                res[j] = intervals[i];
            } else{
                res[j][1] = Math.max(res[j][1], intervals[i][1]);
            }
        }

        int[][] ans = new int[j + 1][];

        while(j >= 0){
            ans[j] = res[j];
            --j;
        }

        return ans;
    }
}