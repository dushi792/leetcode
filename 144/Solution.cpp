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
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> result;
        if (root == NULL)
            return result;
        stack<TreeNode *> stack;
        stack.push(root);
        while (!stack.empty()) {
            TreeNode* visit = stack.top();
            stack.pop();
            result.push_back(visit->val);
            if (visit -> right != NULL)
                stack.push(visit->right);
            if (visit -> left != NULL)
                stack.push(visit->left);
        }
        return result;
    }
};