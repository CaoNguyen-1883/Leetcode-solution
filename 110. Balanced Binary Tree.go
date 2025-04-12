func isBalanced(root *TreeNode) bool {
    res := true;

	var countNode func(root *TreeNode) int;
	countNode = func(root *TreeNode) int{
		if root == nil || res == false{return 0}
		l := countNode(root.Left)
		r := countNode(root.Right)
		if l - r > 1 || r - l > 1{
			res = false;
		}
		return max(l, r) + 1
	}

	return res;
}