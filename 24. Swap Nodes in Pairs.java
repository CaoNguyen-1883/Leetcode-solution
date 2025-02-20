class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode node = head;
        ListNode prev = new ListNode();
        head = head.next;

        while(node != null && node.next != null){
            ListNode swapNode = node.next;
            prev.next = swapNode;

            node.next = swapNode.next;
            swapNode.next = node;

            prev = node;
            node = node.next;
        }

        return head;
    }
}