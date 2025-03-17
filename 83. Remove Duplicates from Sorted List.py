# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution(object):
    def deleteDuplicates(self, head):
        """
        :type head: Optional[ListNode]
        :rtype: Optional[ListNode]
        """
        node = head
        while(node):
            nxt = node.next
            while (nxt and nxt.val == node.val):
                nxt = nxt.next
            node.next = nxt
            node = node.next

        return head