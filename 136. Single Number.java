class Solution {
    // XOR 
    public int singleNumber(int[] nums) {
        int res = 0;

        for(int num : nums)
            res = res ^ num;

        return res;
    }
}

//[4,1,2,1,2]

// 0000 ^ 0100 = 0100
// 0100 ^ 0001 = 0101
// 0101 ^ 0010 = 0111
// 0111 ^ 0001 = 0110
// 0110 ^ 0010 = 0100 = 4   