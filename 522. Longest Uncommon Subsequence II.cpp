#include"LeetCodeLibs.h"

class Solution {
public:
    int findLUSlength(vector<string>& strs) {
        for(string& s : strs) sort(s.begin(), s.end());

        sort(strs.begin(), strs.end(), [](string a, string b){
            return a.size() < b.size();
        });


        return -1;
    }

    bool isSubStr(string s, string sub){
        return s.substr(0, sub.size()) == sub;
    }
};


struct ListNode{
    int val;
    ListNode* next;
};


ListNode *reverseNode(ListNode* head){
    ListNode* before = nullptr, * after = nullptr;
    
    while(head){
        after = head->next;
        head->next = before;
        before = head;
        head = after;
    }
    return before;
}
























