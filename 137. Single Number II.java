
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int singleNumber1(int[] nums) {
        int ans = 0;

        for(int i = 0; i < 32; ++i){
            int sum = 0;
            for(final int num : nums)
                sum += num >> i & 1;

            sum %= 3;
            ans |= sum << i;
        }

        return ans;

    }

    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;

        for (final int num : nums) {
            ones ^= (num & ~twos);
            twos ^= (num & ~ones);
        }

        return ones;
    }
}