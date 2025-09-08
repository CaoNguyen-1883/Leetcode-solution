class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode slow = head;
        ListNode fast = head;

        
        while(n-- > 0 && fast != null){
            fast = fast.next;
        }

        if(fast == null) return head.next;

        while(fast != null && fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }



        if(slow.next != null) slow.next = slow.next.next;


        return head;
    }
}