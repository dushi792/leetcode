// Recursive
public class Solution {
    int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        visit(root, k);
        return res;
    }
    private int visit(TreeNode root, int k) {
        if (root == null)
            return k;
        k = visit(root.left, k);
        k--;
        if (k == 0) {
            res = root.val;
        }
        k = visit(root.right, k);

        return k;
    }
}
// Iterative
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stk = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null) {
            stk.push(cur);
            cur = cur.left;
        }
        while (k > 0 && !stk.isEmpty()) {
            cur = stk.pop();
            k--;
            TreeNode rt = cur.right;
            while (rt != null) {
                stk.push(rt);
                rt = rt.left;
            }
        }
        return cur.val;
    }
}
