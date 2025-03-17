
struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};
 
class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        
        ListNode* node = head;
    
        while(node){
            ListNode* nodeNext = node->next;
            while(nodeNext && nodeNext->val == node->val) nodeNext = nodeNext->next;
            node->next = nodeNext;
            node = node->next;
        }

        return head;
    }
};