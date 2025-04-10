func sortedArrayToBST(nums []int) *TreeNode {
	var build func(left, right int) *TreeNode
	build = func(left, right int) *TreeNode{
		if left > right {return nil}
		mid := (left + right) / 2
		return &TreeNode(nums[mid], build(left, mid - 1), build(mid + 1, right))
	}
	return build(0, len(nums) - 1)
}