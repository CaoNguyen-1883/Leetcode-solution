#include"LeetCodeLibs.h"

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

    class Solution {
    public:
        vector<int> inorderTraversal(TreeNode* root) {
            vector<int> res;
            solve(res, root);
            return res;
        }

        void solve(vector<int>& res, TreeNode* root){
            if(root){
                solve(res, root->left);
                res.push_back(root->val);
                solve(res, root->right);
            }
        }
    };