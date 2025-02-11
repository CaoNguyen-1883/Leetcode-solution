

function ListNode(val, next) {
    this.val = (val===undefined ? 0 : val)
    this.next = (next===undefined ? null : next)
}

/**
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */
var rotateRight = function(head, k) {
    if(!head || !head.next || k == 0) return head;
    let node = head;
    let len = 0;
    while(node){
        node = node.next;
        ++len;
    }

    k %= len;
    if(k == len || k == 0) return head;
    len -= k;
    node = head;

    while(len > 0){
        node = node.next;
        --len;
    }

    let tailNode = node.next;
    while(tailNode.next){
        tailNode = tailNode.next;
    }

    let temp = head;
    head = node.next;
    tailNode.next = temp;
    node.next = null;

    return head;
};