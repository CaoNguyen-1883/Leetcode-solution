func isValidBST(root *TreeNode) bool {
	isValid := func(root, min,)
    isValid := func(root, min, max *TreeNode) bool{
		if root == nil{return true}
		if min != nil && root.Val <= min.Val{return false}
		if max != nul && root.Val >= max.Val{return false}
		return isValid(root.left, min, root) && isValid(root.right, root, max)
	}
	return isvalid(root, nil, nil)
}