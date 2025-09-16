class Solution {
    public void nextPermutation(int[] nums) {
        final int n = nums.length;
        int i;

        // From back to front, find the first number < nums[i + 1].
        for(i = n - 2; i >= 0; --i){
            if(nums[i] < nums[i + 1]) break;
        }

        // 1 2 3 4 5 6 7 8 9

        // From back to front, find the first number > nums[i], swap it with
        // nums[i].
        if(i >= 0){
            for(int j = n - 1; j > i; --j){
                if(nums[j] > nums[i]){
                    this.swap(nums, i, j);
                    break;
                }
            }
        }

        this.reverse(nums, i + 1, n - 1);
    }

    private void reverse(int[] nums, int l, int r){
        while(l < r){
            swap(nums, l++, r--);
        }
    }

    private void swap(int[] nums, int i, int j){
        final int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}