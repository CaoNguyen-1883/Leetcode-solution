 struct ListNode {
     int val;
     ListNode* next;
     ListNode(int x) : val(x), next(NULL) {}
 };

class Solution {
public:
    bool hasCycle(ListNode *head) {
        if(!head || !head->next) return false;

        ListNode* fast = head;

        while(fast && fast->next){
            head = head->next;
            fast = fast->next->next;
            if(fast == head) return true;
        }

        return false;
    }
};