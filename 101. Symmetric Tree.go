type TreeNode struct {
    Val int
    Left *TreeNode
    Right *TreeNode
}

func isSymmetric(root *TreeNode) bool {
	return isSymmetric2(root, root)
}

func isSymmetric2(p *TreeNode, q *TreeNode) bool {
	if p ==  nil || q == nil{
		return p == q;
	}
	return p.Val == q.Val && isSymmetric(p.Left, q.Right) && isSymmetric(p.Right, q.Left);
}