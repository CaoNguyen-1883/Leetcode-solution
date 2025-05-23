func hasPathSum(root *TreeNode, targetSum int) bool {
    if root == nil{return false}

	if(root.Val == targetSum && root.Left == nil && root.Right == nil){
		return true
	}

	return hasPathSum(root.Left, targetSum - root.Val) || hasPathSum(root.Right, targetSum - root.Val)
}