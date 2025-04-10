class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> Optional[TreeNode]:
        def build(left: int, right: int) -> TreeNode | None:
            if left > right:
                return None
            mid = (left + right) // 2
            return TreeNode(nums[mid], build(left, mid - 1), build(mid + 1, right))
        return build(0, len(nums) - 1)