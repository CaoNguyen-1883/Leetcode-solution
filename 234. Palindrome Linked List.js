function ListNode(val, next) {
    this.val = (val===undefined ? 0 : val)
    this.next = (next===undefined ? null : next)
}
 
/**
 * @param {ListNode} head
 * @return {boolean}
 */
var isPalindrome = function(head) {
    node = head;
    count = 0;
    while(node){
        ++count;
        node = node.next;
    }

    count /= 2;
    node = head;

    while(count--){
        node = node.next;
    }

    before = null;
    after = null;
    while(node){
        after = node.next;
        node.next = before;
        before = node;
        node = after;
    }
    node = before;

    while(node && head){
        if(node.val != head.val) return false;
        node = node.next;
        head = head.next;
    }

    return true;
}