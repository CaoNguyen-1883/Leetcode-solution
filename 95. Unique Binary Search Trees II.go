type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}
func generateTrees(n int) []*TreeNode {
	if n == 0{return [] *TreeNode{nil}}
	fn = func(mn, mx int) []* TreeNode{
		if(mn > mx){
			return []*TreeNode{nil};
		}	
	
		res := []* TreeNode{};
	
		for i := mn; i <= mx; i++{
			leftTrees := fn(mn, i-1);
			rightTrees := fn(i+1, mx);
			for _, left := range leftTrees{
				for _, right := range rightTrees{
					root := &TreeNode{Val: i, Left: left, Right: right};
					res = append(res, root)
				}
			}
	
		}
	
		return res
	}
	return fn(1, n)
}

