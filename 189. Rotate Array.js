/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
    n = nums.length;
    k %= n;

    const reverse = (nums, l, r) => {
        while(l < r){
            temp = nums[l];
            nums[l++] = nums[r];
            nums[r--] = temp;
        }
    };
    
    reverse(nums, 0, n - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, n - 1);
};

