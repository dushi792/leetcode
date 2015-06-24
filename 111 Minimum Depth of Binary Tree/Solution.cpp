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
    int minDepth(TreeNode* root) {
        if (!root)
            return 0;
        queue<TreeNode*> que;
        que.push(root);
        int height = 1;
        TreeNode* endlevel = root;
        while (!que.empty()) {
            TreeNode* node = que.front();
            que.pop();
            if (node->left)
                que.push(node->left);
            if (node->right)
                que.push(node->right);
            if (!node->left && !node->right)
                break;
            if (node == endlevel) {
                height++;
                endlevel = que.back();
            }
        }
        return height;
    }
};