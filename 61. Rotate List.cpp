struct ListNode {
     int val;
     ListNode *next;
     ListNode() : val(0), next(nullptr) {}
     ListNode(int x) : val(x), next(nullptr) {}
     ListNode(int x, ListNode *next) : val(x), next(next) {}
 };


class Solution {
public:
    ListNode* rotateRight(ListNode* head, int k) {

        if(!head || !head->next || k == 0) return head;

        ListNode* node = head;
        int len = 0;

        while(node){
            ++len;
            node = node->next;
        }

        k = k % len;

        if(k == len || k == 0) return head;

        len -= k;
        node = head;


        while(--len){
            node = node->next;
        }

        ListNode* tailNode = node->next;
        ListNode* temp = head;

        while(tailNode->next){
            tailNode = tailNode->next;
        }
        
        head = node->next;
        tailNode->next = temp;
        node->next = nullptr;

        return head;
    }
}