
import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);

    }
    public static void reverse(int[] nums, int begin, int end){
        while(begin < end){
            int temp = nums[begin];
            nums[begin++] = nums[end];
            nums[end++] = temp;
        }
    }
}