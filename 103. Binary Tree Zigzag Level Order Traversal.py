from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        res = []
        q = deque([root])
        isLeft = True

        while q:
            l = []
            for i in range(len(q)):
                node = q.popleft()
                l.append(node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            
            if isLeft:
                res.append(l)
            else:
                res.append(list(reversed(l)))
            isLeft = not isLeft
        return res
