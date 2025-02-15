function ListNode(val) {
    this.val = val;
    this.next = null;
}
 
/**
 * @param {ListNode} headA
 * @param {ListNode} headB
 * @return {ListNode}
 */
var getIntersectionNode = function(headA, headB) {
    let a = headA;
    let b = headB;
    let i = 0, j = 0;

    while(a){
        ++i;
        a = a.next;
    }

    while(b){
        ++j;
        b = b.next;
    }

    while(i < j){
        --j;
        headB = headB.next;
    }

    while(j < i){
        --i;
        headA = headA.next;
    }

    while(headA && headB){
        if(headA == headB) return headA;
        headA = headA.next;
        headB = headB.next; 
    }

    return null;
};

