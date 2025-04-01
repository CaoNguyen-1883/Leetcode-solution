class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        Map = {}
        for i, a in enumerate(inorder):
            Map[a] = i

        ind = 0
        def dfs(l, r):
            if l > r:
                return None

            nonlocal ind
            root_val = preorder[ind]
            ind += 1
            root = TreeNode(root_val)
            mid = Map[root_val]
            root.left = dfs(l, mid - 1)
            root.right = dfs(mid + 1, r)

            return root

        return dfs(0, len(preorder) - 1)