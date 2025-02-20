
struct ListNode {
     int val;
     ListNode *next;
     ListNode() : val(0), next(nullptr) {}
     ListNode(int x) : val(x), next(nullptr) {}
     ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
    public:
        ListNode* swapPairs(ListNode* head) {
            if(!head || !head->next) return head;
            
            ListNode* node = head;
            head = head->next;
            ListNode* prev = new ListNode();

            while(node && node->next){
                ListNode* swapNode = node->next;
                prev->next = swapNode;

                node->next = swapNode->next;
                swapNode->next = node;
                
                prev = node;
                node = node->next;
            }

            return head;
        }
    };