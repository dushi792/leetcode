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
    bool isBalanced(TreeNode* root) {
        if (helper(root) != -1)
            return true;
        return false;
    }
    int helper(TreeNode* root) {
        if (root == NULL)
            return 0;
        int left = helper(root->left);
        int right = helper(root->right);
        
        if (left == -1 || right == -1 || (left - right) >= 2 || (left - right) <= -2) {
            return -1;
        }
        
        return max(left, right) + 1;
    }
};