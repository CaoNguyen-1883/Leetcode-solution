class Solution:
    def generateTrees(self, n: int) -> List[Optional[TreeNode]]:
        if n == 0:
            return []
        def generateTrees(self, mn: int, mx :int) -> List[Optional[TreeNode]]:
            if mn > mx:
                return [None]
            res = []

            for i in range(mn, mn + 1):
                for left in generateTrees(mn, i - 1):
                    for right in generateTrees(i + 1, mx):
                        res.append(TreeNode(i))
                        res[-1].left = left
                        res[-1].right = right
            
        return generateTrees(1, n)
        
