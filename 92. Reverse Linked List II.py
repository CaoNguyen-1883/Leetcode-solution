
        
class Solution(object):
    def reverseBetween(self, head, left, right):
        """
        :type head: Optional[ListNode]
        :type left: int
        :type right: int
        :rtype: Optional[ListNode]
        """
        if left == right or not head: return head

        yummy = ListNode(0, head)
        node = yummy
        for i in range(0, left - 1):
            node = node.next

        tail = node.next

        for i in range(0, right - left):
            cache = tail.next
            tail.next = cache.next
            cache.next = node.next
            node.next = cache

        return yummy.next