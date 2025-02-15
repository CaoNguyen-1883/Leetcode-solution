class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        int i = 0;
        int j = 0;

        while(a != null){
            ++i;
            a = a.next;
        }

        while(b != null){
            ++j;
            b = b.next;
        }

        while(i < j){
            --j;
            headB = headB.next;
        }

        while(j < i){
            i--;
            headA = headA.next;
        }

        while(headA != null && headB != null){
            if(headA == headB) return headB;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}