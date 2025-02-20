/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
    let countZero = 0, n = nums.length;

    for(let i = 0; i < n; ++i){
        if(nums[i] != 0){
            nums[countZero++] = nums[i];
        }
    }

    while(countZero < n) nums[countZero++] = 0;
};