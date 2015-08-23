// THis solution do not have constant space, to have constant space, use Morris Traversal:
// https://leetcode.com/discuss/26310/detail-explain-about-morris-traversal-finds-incorrect-pointer
public class Solution {
    public void recoverTree(TreeNode root) {
        if (root == null) return;
        LinkedList<TreeNode> pre = new LinkedList<TreeNode>();
        LinkedList<TreeNode> res = new LinkedList<TreeNode>();
        pre.add(null);
        inOrder(root, pre, res);
        int temp = res.get(0).val;
        res.get(0).val = res.get(1).val;
        res.get(1).val = temp;
    }
    private void inOrder(TreeNode root, LinkedList<TreeNode> pre, LinkedList<TreeNode> res) {
        if (root == null) return;
        inOrder(root.left, pre, res);
        if (pre.get(0) != null && pre.get(0).val > root.val) {
            if (res.size() == 0) {
                res.add(pre.get(0));
                res.add(root);
            }
            else
                res.add(0, root);
        }
        pre.add(0, root);
        inOrder(root.right, pre, res);
    }
}
