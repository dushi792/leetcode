//Using queue
class BSTIterator {
public:
    BSTIterator(TreeNode *root) {
        pushAll(root);
    }

    /** @return whether we have a next smallest number */
    bool hasNext() {
        return !que.empty();
    }

    /** @return the next smallest number */
    int next() {
        if (!que.empty()) {
            int res = que.front()->val;
            que.pop();
            return res;
        }
        else
            return 0;
    }
private: queue<TreeNode*> que;
    void pushAll(TreeNode* root) {
        if (root) {
            if (root->left)
                pushAll(root->left);
            que.push(root);
            if (root->right)
                pushAll(root->right);
        }
    }
};
//Using stack
/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class BSTIterator {
public:
    BSTIterator(TreeNode *root) {
        pushNodes(root);
    }

    /** @return whether we have a next smallest number */
    bool hasNext() {
        return !stk.empty();
    }

    /** @return the next smallest number */
    int next() {
        TreeNode* top = stk.top();
        stk.pop();
        pushNodes(top->right);
        return top->val;
    }
    
private: stack<TreeNode*> stk;
    void pushNodes (TreeNode* root) {
        while (root) {
            stk.push(root);
            root = root->left;
        }
    }
};

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = BSTIterator(root);
 * while (i.hasNext()) cout << i.next();
 */