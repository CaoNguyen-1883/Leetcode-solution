func inorderTraversal(root *TreeNode) []int {
	res := int[]
	if root == nil{ return res}

	stack := *TreeNode[]{}
	for root != nil{
		stack = apend(stack, root)
		root = root.Left
	}
	for len(stack) > 0{
		node := stack[len(stack) - 1]
		res = apend(res, node.Val)
	}
	return res;
}