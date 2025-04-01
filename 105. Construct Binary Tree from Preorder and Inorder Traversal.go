func buildTree(preorder []int, inorder []int) *TreeNode {
	mp := make(map[int]int)
	for i, val := range inorder{
		mp[val] = i
	}
	ind := 0
    
	var dfs func(l, r int) *TreeNode
	dfs = func(l, r int) *TreeNode{
		if(l > r){
			return nil
		}
		rootVal := preorder[ind]
		ind++;
		root := &TreeNode{Val: rootVal}
		mid := mp[rootVal]
		root.Left = dfs(l, mid - 1)
		root.Right = dfs(mid + 1, r)
        return root
	}
	return dfs(0, len(preorder) - 1)
}	