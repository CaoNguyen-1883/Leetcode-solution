class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode beforeHead = new ListNode();
        ListNode afterHead = new ListNode();
        ListNode before = beforeHead;
        ListNode after = afterHead;

        while(head != null){
            if(head.val < x){
                before.next = head;
                before = before.next;
            } else{
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        after.next = null;
        before.next = afterHead.next;

        return beforeHead.next;
    }
}