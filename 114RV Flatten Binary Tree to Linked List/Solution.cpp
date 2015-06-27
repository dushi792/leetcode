/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    void flatten(TreeNode* root) {
        stack<TreeNode*> stk;
        if (root) stk.push(root);
        while (!stk.empty()) {
            TreeNode* curr = stk.top();
            stk.pop();
            if (curr->right) stk.push(curr->right);
            if (curr->left) stk.push(curr->left);
            if (!stk.empty()) curr->right = stk.top();
            curr->left = NULL;
        }
    }
    
};