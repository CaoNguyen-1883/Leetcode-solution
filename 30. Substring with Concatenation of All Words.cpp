#include"LeetCodeLibs.h"


class Solution {
public:
    vector<int> findSubstring(string s, vector<string>& words) {
        if(s.empty() || words.empty()) return {};

        vector<int> res;
        int n = s.size(), m = words.size(), k = words[0].size();
        unordered_map<string, int> count;
        
        for(string& word : words) ++count[word];

        for(int offset = 0; offset < k; ++offset){
            int l = offset;
            int matched = 0;
            unordered_map<string, int> seen;

            for(int r = offset; r <= n - k; r += k){
                string word = s.substr(r, k);

                if(count.count(word)){
                    ++seen[word];
                    ++matched;
                    
                    while(seen[word] > count[word]){
                        string leftWord = s.substr(l, k);
                        --seen[leftWord];
                        --matched;
                        l += k;
                    }

                    if(matched == m){
                        res.push_back(l);
                    }
                } else{
                    seen.clear();
                    matched = 0;
                    l = r + k;
                }
            }
        }

        return res;
    }; 

};


class Solution1 {
public:
    vector<int> findSubstring(string s, vector<string>& words) {
        if (s.empty() || words.empty()) return {};

        int n = s.size(), m = words.size(), k = words[0].size();
        unordered_map<string, int> count;
        vector<int> res;

        for (const string& w : words) ++count[w];

        for (int offset = 0; offset < k; ++offset) {
            unordered_map<string, int> seen;
            int left = offset, matched = 0;

            for (int right = offset; right + k <= n; right += k) {
                string word = s.substr(right, k);

                if (count.count(word)) {
                    ++seen[word];
                    ++matched;

                    while (seen[word] > count[word]) {
                        string leftWord = s.substr(left, k);
                        --seen[leftWord];
                        --matched;
                        left += k;
                    }

                    if (matched == m) res.push_back(left);
                } 
                else {
                    seen.clear();
                    matched = 0;
                    left = right + k;
                }
            }
        }

        return res;
    }
};



class Solution01 {
public: 
    vector<int> findSubstring(string s, vector<string>& words) {
        if(s.empty() || words.empty()) return {};
        
        vector<int> res;
        unordered_map<string, int> count;
        int n = s.size();
        int m = words.size();
        int k = words[0].size();

        for(string& w : words) ++count[w];


        for(int i = 0; i <= n - m*k; ++i){
            unordered_map<string, int> seen;

            int j = 0;
            for(; j < m; ++j){
                string word = s.substr(i + j*k, k);
                if(++seen[word] > count[word]) break;
            }

            if(j == m) res.push_back(i);
        }



        return res;
    }
};
//Time limitedlimited
class Solution2 {
public:
    void backtrack(const vector<string>& words, vector<bool>& used, vector<string>& current, vector<string>& result) {
        if (current.size() == words.size()) {
            string concatenated;
            for (const auto& s : current) {
                concatenated += s;
            }
            result.push_back(concatenated);
            return;
        }
        
        for (int i = 0; i < words.size(); i++) {

            if (used[i]) continue;

            if (i > 0 && words[i] == words[i-1] && !used[i-1])
                continue;
            
            used[i] = true;
            current.push_back(words[i]);
            backtrack(words, used, current, result);
            current.pop_back();
            used[i] = false;
        }
    }

    vector<int> findSubstring(string s, vector<string>& words) {
        if(s.size() < words.size()) return {};


        vector<int> res;
        int n = s.size();
        int m = words[0].size() * words.size();

        vector<string> v;
        vector<bool> used(words.size(), false);
        vector<string> current;
        backtrack(words, used, current, v);
        unordered_set<string> st;

        for(string& i : v) st.insert(i);

        for(int i = 0; i <= n - m; ++i){
            if(st.count(s.substr(i, m))){
                res.push_back(i);
                i += words[0].size() - 1;
            }
        }


        return res;
    }
};