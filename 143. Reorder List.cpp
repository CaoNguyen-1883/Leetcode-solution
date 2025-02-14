struct ListNode {
    int val;
    ListNode* next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode* next) : val(x), next(next) {}
};

class Solution {
public:
    void reorderList(ListNode* head) {
        if(!head || !head->next || !head->next->next) return;
   
        int count = 0;

        for(ListNode* node = head->next; node; node = node->next){
            ++count;
        }

        count /= 2;

        ListNode* rightNode = head->next;
        ListNode* leftNode = head->next;

        while(--count) rightNode = rightNode->next;

        ListNode* temp = rightNode;
        rightNode = rightNode->next;
        temp->next = nullptr;

        ListNode* left = nullptr;
        ListNode* right = nullptr;

        while(rightNode){
            right = rightNode->next;
            rightNode->next = left;
            left = rightNode;
            rightNode = right;
        }

        rightNode = left;
        head->next = rightNode;

        while(rightNode && leftNode){
            left = leftNode;
            right = rightNode;
            rightNode = rightNode->next;
            leftNode = leftNode->next;
            
            right->next = left;
            left->next = rightNode;
        }
    }
};