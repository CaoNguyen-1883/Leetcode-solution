class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) return null;

        ListNode l1 = list1;
        ListNode l2 = list2;
        ListNode head = new ListNode(0);
        ListNode h = head;

        while( l1 != null && l2 != null){
            if(l1.val < l2.val){
                h.next = new ListNode(l1.val);
                h = h.next;
                l1 = l1.next;
            } else{
                h.next = new ListNode(l2.val);
                h = h.next;
                l2 = l2.next;
            }
        }

        while(l1 != null){
            h.next = new ListNode(l1.val);
            h = h.next;
            l1 = l1.next;
        }

        while(l2 != null){
            h.next = new ListNode(l2.val);
            h = h.next;
            l2 = l2.next;
        }

        return head.next;
    }
}