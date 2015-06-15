//common solution
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
        TreeLinkNode* head = NULL;
        TreeLinkNode* pre = NULL;
        TreeLinkNode* curr = root;
        
        while (curr != NULL) {
            //iterate current level;
            while (curr != NULL) {
                if (curr->left != NULL) {
                    if (pre != NULL) {
                        pre->next = curr->left;
                        pre = curr->left;
                    }
                    else {
                        pre = curr->left;
                        head = curr->left;
                    }
                }
                if (curr->right != NULL) {
                    if (pre != NULL) {
                        pre->next = curr->right;
                        pre = curr->right;
                    }
                    else {
                        pre = curr->right;
                        head = curr->right;
                    }
                }
                curr = curr->next;
            }
            //change to next level;
            curr = head;
            pre = NULL;
            head = NULL;
        }
    }
};

//Simple Solution
public class Solution {
    public void connect(TreeLinkNode root) {

        while(root != null){
            TreeLinkNode tempChild = new TreeLinkNode(0);
            TreeLinkNode currentChild = tempChild;
            while(root!=null){
                if(root.left != null) { currentChild.next = root.left; currentChild = currentChild.next;}
                if(root.right != null) { currentChild.next = root.right; currentChild = currentChild.next;}
                root = root.next;
            }
            root = tempChild.next;
        }
    }
}