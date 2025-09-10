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
            ListNode node2 = node.next;
            ListNode node3 = node2.next;
            prev.next = node2;

            prev = node;
            node2.next = node;
            node.next = node3;
            node = node3;
            
        }

        return head;
    }
}

// 1 2 3 4 
//  
// class Solution {
//     public ListNode swapPairs(ListNode head) {
//         if(head == null || head.next == null) return head;

//         ListNode node = head;
//         ListNode prev = new ListNode();
//         head = head.next;

//         while(node != null && node.next != null){
//             ListNode swapNode = node.next;
//             prev.next = swapNode;

//             node.next = swapNode.next;
//             swapNode.next = node;

//             prev = node;
//             node = node.next;
//         }

//         return head;
//     }
// }