
struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:


    ListNode* reverseKGroup(ListNode* head, int k) {
        if(k < 2) return head;
        ListNode* node = head;
        int count = 0;
        while(node){
            node = node->next;
            ++count;
        }
        if(k > count) k %= count;
        node = head;

        for(int i = 0; i < k - 1; ++i) head = head->next;
        ListNode* prev = new ListNode();
        
        while(count >= k){
            ListNode* after = nullptr;
            ListNode* before = nullptr;
            ListNode* temp = node;
            for(int i = 0; i < k; ++i){
                after = node->next;
                node->next = before;
                before = node;
                node = after;
            }
            prev->next = before;
            prev = temp;
            count -= k;
        }

        if(count > 0) prev->next = node;

        return head;
    }
};