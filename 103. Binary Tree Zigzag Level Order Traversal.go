type TreeNode struct {
    Val int
    Left *TreeNode
    Right *TreeNode
}

func zigzagLevelOrder(root *TreeNode) [][]int {
	res := [][]int{};
	if root == nil{return res}
	
	queue := []*TreeNode{root};
	isLeft := true;

	for len(queue) > 0{
		l := []int{}
		n := len(queue)
		for i := 0; i < n; i++{
			node := queue[0]
			queue = queue[1:]

			if isLeft {
				l = append(l, node.Val)
			} else {
				l = append([]int{node.Val}, l...)
			}

			if(node.Left != nil) {
				queue = append(queue, node.Left)
			}
			if(node.Right != nil) {
				queue = append(queue, node.Right)
			}
		}
		res = append(res, l)
		isLeft = !isLeft
	}

	return res
}