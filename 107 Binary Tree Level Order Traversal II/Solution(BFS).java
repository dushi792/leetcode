/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null)
            return res;
        helper(res, root, 0);
        return res;
    }
    void helper(List<List<Integer>> res, TreeNode root, int level) {
        if (root == null)
            return;
        if (res.size() == level)
            res.add(0, new ArrayList<Integer>());
        res.get(res.size()-level-1).add(root.val);
        helper(res, root.left, level+1);
        helper(res, root.right, level+1);
    }
}