class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode yummy = new ListNode(0);
        ListNode node = yummy;

        while(carry == 1 || l1 != null || l2 != null){
            int num = carry;

            if(l1 != null){
                num += l1.val;
                l1 = l1.next;
            }

            if(l2 != null){
                num += l2.val;
                l2 = l2.next;
            }

            node.next = new ListNode(num % 10);
            node = node.next;  
            carry = num / 10;            
        }

        return yummy.next;
    }
}