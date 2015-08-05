/**
 * Definition for binary tree with next pointer.
 * struct TreeLinkNode {
 *  int val;
 *  TreeLinkNode *left, *right, *next;
 *  TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL) {}
 * };
 */
class Solution {
public:
    void connect(TreeLinkNode *root) {
        if (root == NULL || root->left == NULL)
            return;
        TreeLinkNode *start = root;
        root->left->next = root->right;
        while (root->next != NULL) {
            root->right->next = root->next->left;
            root = root->next;
            if (root->left != NULL)
                root->left->next = root->right;
        }
        connect(start->left);
    }
};