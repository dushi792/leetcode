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
    int sumNumbers(TreeNode* root) {
        if (!root)
            return 0;
        return DFS(root, 0);
    }
    int DFS(TreeNode* root, int res) {
        if (!root->left && !root->right) {
            return 10*res+root->val;
        }
        int sum = 0;
        if (root->left)
            sum += DFS(root->left, res*10+root->val);
        if (root->right)
            sum += DFS(root->right, res*10+root->val);
        return sum;
    }
};