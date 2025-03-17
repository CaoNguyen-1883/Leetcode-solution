public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;

        while(node != null){
            ListNode nodeNext = node.next;
            while(nodeNext != null && nodeNext.val == node.val) nodeNext = nodeNext.next;
            node.next = nodeNext;
            node = node.next;
        }

        return head;
    }
}