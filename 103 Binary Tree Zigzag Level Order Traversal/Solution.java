// 还应该尝试一下用stack解决
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        helper(root, res, 0);
        return res;
    }
    private void helper(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) return;
        if (res.size() == level) res.add(new LinkedList<Integer>());
        if (level%2 == 0) res.get(level).add(root.val);
        if (level%2 == 1) res.get(level).add(0, root.val);
        helper(root.left, res, level+1);
        helper(root.right, res, level+1);
    }
}
