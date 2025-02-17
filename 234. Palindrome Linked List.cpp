struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
     ListNode(int x, ListNode *next) : val(x), next(next) {}
};
class Solution {
public:
    bool isPalindrome(ListNode* head) {
        int count = 0;
        ListNode* node = head;

        while(node){
            ++count;
            node = node->next;
        }

        count /= 2;
        node = head;

        while(count--){
            node = node->next;
        }

        ListNode* before = nullptr, * after = nullptr;
        while(node){
            after = node->next;
            node->next = before;
            before = node;
            node = after;
        }
        node = before;

        while(node && head){
            if(node->val != head->val) return false;
            node = node->next;
            head = head->next;
        }

        return true;
    }
};