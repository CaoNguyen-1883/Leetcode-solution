
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode node = head;
        int len = 0;
        while(node != null){
            ++len;
            node = node.next;
        }

        k = k % len;
        if(len == k || k == 0) return head;
        node = head;
        len -= k;

        ListNode tailNode;
        
        while(--len > 0){
            node = node.next;
        }
        tailNode = node.next;

        while(tailNode.next != null){
            tailNode = tailNode.next;
        }

        ListNode temp = head;
        head = node.next;
        tailNode.next = temp;
        node.next = null;

        return head;

    }
}