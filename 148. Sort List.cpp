#include<vector>
#include<algorithm>

using namespace std;

struct ListNode {
    int val;
    ListNode* next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode* next) : val(x), next(next) {}
};

class Solution {
public:
    ListNode* sortList(ListNode* head) {
        if(!head || !head->next) return head;

        vector<int> list;
        ListNode* node = head;

        while(head){
            list.push_back(head->val);
            node = node->next;
        }

        std::sort(list.begin(), list.end());

        node = head;

        for(int& item : list){
            node->val = item;
            node = node->next;
        }
        
        return head;
    }

    ListNode* sortList(ListNode* head){

    }

    ListNode* getMid(ListNode* head){
        ListNode* slow = head;
        ListNode* fast = head;       

        while(fast && fast->next){
            slow = slow->next;
            fast = fast->next->next;
        }        

        return slow;    
    }

    void mergeNode(ListNode* head1, ListNode* head2){
        while(head1 && head2){
            if(head1->val < head2->val){
                swap(head1->val, head2->val);
                head1 = head1->next;
            } else{
                swap(head1->val, head2->val);
                head2 = head2->next;
            }
        }
        while(head1){

        }
    }
};  