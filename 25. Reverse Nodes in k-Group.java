class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1) return head;
        
        ListNode node = head;

        int count = 0;

        while(node != null){
            node = node.next;
            ++count;
        }

        node = head;

        for(int i = 0; i < k - 1; ++i){
            head = head.next;
        }

        ListNode prev = new ListNode();
        
        while(count >= k){
            ListNode before = null;
            ListNode after = null;
            ListNode temp = node;
            for(int i = 0; i < k; ++i){
                after = node.next;
                node.next = before;
                before = node;
                node = after;
            }
            prev.next = before;
            prev = temp;
            count -= k;
        }

        if(count > 0) prev.next = node;

        return head;
    }
}
// 1 2 3 