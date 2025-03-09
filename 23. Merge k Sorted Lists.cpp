#include"LeetCodeLibs.h"

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        if(lists.empty()) return nullptr;
        vector<int> v;
        for(int i =0; i < lists.size(); ++i){
            ListNode* node = lists[i];
            while(node){
                v.push_back(node->val);
                node = node->next;
            }
        }

        sort(v.begin(), v.end());
        ListNode res(0);   
        ListNode* node = &res;
        for(int& i : v){
            node->next = new ListNode(i);
            node = node->next;
        }
        return res.next;
    }
};

class Solution2 {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        using P = pair<int, ListNode*>;
        priority_queue<P, vector<P>, greater<P>> minHeap;
        
        for(ListNode* head : lists){
            if(head){
                minHeap.push({head->val, head});
            }
        }
        if(minHeap.empty()) return nullptr;

        ListNode* res = new ListNode(0);
        ListNode* node = res;

        while(!minHeap.empty()){
            pair<int, ListNode*> p = minHeap.top();
            minHeap.pop();

            node->next = p.second;
            node = node->next;

            if(p.second->next){
                minHeap.push({p.second->next->val, p.second->next});
            }
        }
        return res->next;
    }
};

