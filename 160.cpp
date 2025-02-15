#include"LeetCodeLibs.h"


struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
 };

class Solution {
public:

    ListNode *getIntersectionNode(ListNode* headA, ListNode *headB) {
        ListNode* a = headA;
        ListNode* b = headB;
        
        while(a != b){
            a = (a ? a->next : headB);
            b = (b ? b->next : headA);
        }

        return a;
    }

    ListNode *getIntersectionNode(ListNode* headA, ListNode *headB) {
        unordered_set <ListNode*> st;

        while(headA){
            st.insert(headA);
            headA = headA->next;
        }

        while(headB){
            if(st.find(headB) != st.end()) return headB;
            headB = headB->next;
        }

        return nullptr;
    }

    ListNode  *getIntersectionNode(ListNode* headA, ListNode *headB){
        ListNode* a = headA;
        ListNode* b = headB;

        int i = 0;
        int j = 0;

        while(a){
            ++i;
            a = a->next;
        }

        while(b){
            ++j;
            b = b->next;
        }

        while(i < j){
            --j;
            headB = headB->next;
        }

        while(j < i){
            i--;
            headA = headA->next;
        }

        while(headA && headB){
            if(headA == headB) return headB;
            headA = headA->next;
            headB = headB->next;
        }
        return nullptr;
    }
};