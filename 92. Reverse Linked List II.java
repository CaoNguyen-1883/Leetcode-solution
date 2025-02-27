class ListNode{
    public int val;

    public ListNode next;

    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

class Solution{
    public ListNode reverseBetween(ListNode head, int left, int right){
        if(left == right || head == null) return head;

        ListNode yummy = new ListNode(0, head);
        ListNode node = yummy;

        for(int i = 0; i < left - 1; ++i) node = node.next;

        ListNode tail = node.next;

        for(int i = 0; i < right - left; ++i){
            ListNode cache = tail.next;
            tail.next = cache.next;
            cache.next = node.next;
            node.next = cache;
        }

        return yummy.next;
    }
}