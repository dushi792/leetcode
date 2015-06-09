/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
//recursive
class Solution {
public:
    vector<int> res;
    vector<int> postorderTraversal(TreeNode* root) {
        if (root != NULL){
            postorderTraversal(root->left);
            postorderTraversal(root->right);
            res.push_back(root->val);
        }
        return res;
    }
};