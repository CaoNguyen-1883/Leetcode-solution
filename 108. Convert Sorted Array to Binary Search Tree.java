class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }
    public TreeNode build(int[] nums, int l, int r){
        if(l > r) return null;
        int m = (l + r ) / 2;
        return new TreeNode(nums[m], build(nums, l, m  - 1), build(nums, m + 1, r));
    }
}       