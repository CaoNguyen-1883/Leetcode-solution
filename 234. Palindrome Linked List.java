public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        int count = 0;
        ListNode node = head;
        while(node != null){
            ++count;
            node = node.next;
        }

        count /= 2;
        node = head;

        while(count > 0){
            --count;
            node = node.next;
        }

        ListNode after = null, before = null;
        while(node != null){
            after = node.next;
            node.next = before;
            before = node.next;
            node = after;
        }
        node = before;

        while(node != null && head != null){
            if(node.val != head.val) return false;
            node = node.next;
            head = head.next;
        }

        return true;
    }
}