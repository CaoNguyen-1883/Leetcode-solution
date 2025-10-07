class Solution {
    public Node connect(Node root) {
        // if (root == null)
        //     return null;
        // connectTwoNodes(root.left, root.right);
        traverse(root, null, true);
        return root;
    }

    private void connectTwoNodes(Node p, Node q) {
        if (p == null)
            return;
        p.next = q;
        connectTwoNodes(p.left, p.right);
        connectTwoNodes(q.left, q.right);
        connectTwoNodes(p.right, q.left);
    }
    private void traverse(Node node, Node parent, boolean nodeIsLeftChild){
        if(node == null) return;
        if(nodeIsLeftChild){
            node.next = parent == null ? null : parent.right;
        } else{
            node.next = (parent == null || parent.next == null) ? null : parent.next.left;
        }
        traverse(node.left, node, true);
        traverse(node.right, node, false);
    }
}