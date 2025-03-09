import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Pair {
    int val;
    ListNode listNode;

    Pair(int val, ListNode listNode) {
        this.val = val;
        this.listNode = listNode;
    }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode head : lists) {
            if (head != null) {
                minHeap.offer(new Pair(head.val, head));
            }
        }

        if (minHeap.isEmpty()) return null;

        ListNode res = new ListNode(0);
        ListNode node = res;

        while (!minHeap.isEmpty()) {
            Pair p = minHeap.poll();

            node.next = p.listNode;
            node = node.next;

            if (p.listNode.next != null) {
                minHeap.offer(new Pair(p.listNode.next.val, p.listNode.next));
            }
        }

        return res.next;
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