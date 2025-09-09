import java.util.PriorityQueue;
import java.util.Queue;



class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode node = head;


        Queue <Pair> q = new PriorityQueue<>((a, b) -> a.val - b.val);

        for(ListNode i : lists){
            if(i != null){
                q.add(new Pair(i.val, i));
            }
        }

        while(!q.isEmpty()){
            Pair p = q.poll();
            node.next = new ListNode(p.val);
            node = node.next;
            if(p.listNode.next != null){
                q.add(new Pair(p.listNode.next.val, p.listNode.next));
            }
        }

        return head.next;
    }

    static class Pair {
        int val;
        ListNode listNode;

        Pair(int val, ListNode listNode) {
            this.val = val;
            this.listNode = listNode;
        }
    }
} 

// class Solution {
//     public ListNode mergeKLists(ListNode[] lists) {
//         PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

//         for (ListNode head : lists) {
//             if (head != null) {
//                 minHeap.offer(new Pair(head.val, head));
//             }
//         }

//         if (minHeap.isEmpty()) return null;

//         ListNode res = new ListNode(0);
//         ListNode node = res;

//         while (!minHeap.isEmpty()) {
//             Pair p = minHeap.poll();

//             node.next = p.listNode;
//             node = node.next;

//             if (p.listNode.next != null) {
//                 minHeap.offer(new Pair(p.listNode.next.val, p.listNode.next));
//             }
//         }

//         return res.next;
//     }

//     static class Pair {
//         int val;
//         ListNode listNode;

//         Pair(int val, ListNode listNode) {
//             this.val = val;
//             this.listNode = listNode;
//         }
//     }
// } 