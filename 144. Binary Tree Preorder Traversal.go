func preorderTraversal(root *TreeNode) []int {
	if root == nil{return []int{}}
    var res []int;
	stack := []*TreeNode{root}

	for len(stack) > 0{
		node := stack[len(stack) - 1]
		stack := stack[1:]
		res = append(res, node.Val)
		if node.Right != nil{stack = append(stack, node.Right)}
		if node.Left != nil{stack = append(stack, node.Left)}
	
	}

	return res;
}
