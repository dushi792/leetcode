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
    bool hasPathSum(TreeNode* root, int sum) {
        if (!root)
            return false;
        int res = DFS(root, sum, 0);
        if (res == 0) return true;
        else return false;
    }
    
    int DFS(TreeNode* root, int sum, int currsum) {
        currsum += root->val;
        if (!root->left && !root->right) {
            if (currsum == sum) return 0;
            else return -1;
        }
        if (root->left) {
            int res = DFS(root->left, sum, currsum);
            if (res == 0) return 0;
        }
        if (root->right) {
            int res = DFS(root->right, sum, currsum);
            if (res == 0) return 0;
        }
        return -1;
    }
};

//Improved version
class Solution {
public:
    bool hasPathSum(TreeNode* root, int sum) {
        if (!root)
            return false;
        if (!root->left && !root->right && root->val - sum == 0)
            return true;
        return hasPathSum(root->left, sum - root->val) || hasPathSum(root->right, sum - root->val);
    }
};