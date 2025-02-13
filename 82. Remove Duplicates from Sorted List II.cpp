


struct ListNode {
    int val;
    ListNode* next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode ext) : val(x), next(next) {}
};

class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        if (!head || !head->next) return head;
            while (head->next != nullptr && head->val == head->next->val) {
                int val = head->val;
                while (head != nullptr && head->val == val) {
                    head = head->next;
                }
                if (head == nullptr) return nullptr;
            }

            ListNode* node = head;
            while (node != nullptr) {
                ListNode* temp = node->next;
                if (temp != nullptr && temp->next != nullptr && temp->val == temp->next->val) {
                    int val = temp->val;
                    while (temp != nullptr && temp->val == val) {
                        temp = temp->next;
                    }
                    node->next = temp;
                } else {
                    node = node->next;
                }
            }

            return head;
    }
};