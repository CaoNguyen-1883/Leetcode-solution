func postorderTraversal(root *TreeNode) []int {
    if root == nil{
		return []int{};
	}

	var res []int;

	stack := []*TreeNode{root};

	for len(stack) > 0{
		node := stack[len(stack) - 1];
		stack = stack[:len(stack) - 1];
		res = append(res, node.Val)
		if node.Left != nil{
			stack = append(stack, node.Left);
		}

		if node.Right != nil{
			stack = append(stack, node.Right);
		}
	}
	
	for i, j := 0, len(res)-1; i < j; i, j = i+1, j-1 {
		res[i], res[j] = res[j], res[i]
	}

	return res;
}