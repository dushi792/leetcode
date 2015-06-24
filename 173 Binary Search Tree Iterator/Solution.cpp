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