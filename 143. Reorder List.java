class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;
        
        int count = 0;

        for(ListNode node = head.next; node != null; node = node.next) ++count;

        count /= 2;
        ListNode leftNode = head.next;
        ListNode rightNode = head.next;

        while(count > 1){
            --count;
            rightNode = rightNode.next;
        }

        ListNode temp = rightNode;
        rightNode = rightNode.next;
        temp.next = null;

        ListNode left = null;
        ListNode right = null;

        while(rightNode != null){
            right = rightNode.next;
            rightNode.next = left;
            left = rightNode;
            rightNode = right;
        }

        rightNode = left;
        head.next = rightNode;

        while(rightNode != null && leftNode != null){
            right = rightNode;
            left = leftNode;
            rightNode = rightNode.next;
            leftNode = leftNode.next;

            right.next = left;
            left.next = rightNode;
        }

    }
}