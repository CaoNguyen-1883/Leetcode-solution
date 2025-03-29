func kthSmallest(root *TreeNode, k int) int {
	n := countNodes(root.Left)
	if n == k - 1{
		return root.Val
	}
    if n >= k{
		return kthSmallest(root.Left, k)
	} 
	return kthSmallest(root.Right, k - n - 1)
}

func countNodes(root *TreeNode) int{
	if root == nil{return 0}
	return 1 + countNodes(root.Left) + countNodes(root.Right)
}