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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        List<Integer> curr = new LinkedList<Integer>();
        if (root == null)
            return res;
        curr.add(root.val);
        DFS(root, sum, res, curr);
        return res;
    }
    private void DFS(TreeNode root, int sum, List<List<Integer>> res, List<Integer> curr) {
        if (root.left == null && root.right == null && sum - root.val == 0) {
            res.add(new LinkedList<Integer>(curr));
            return;
        }
        if (root.left != null) {
            curr.add(root.left.val);
            DFS(root.left, sum-root.val, res, curr);
            curr.remove(curr.size()-1);
        }
        if (root.right != null) {
            curr.add(root.right.val);
            DFS(root.right, sum-root.val, res, curr);
            curr.remove(curr.size()-1);
        }
    }
}
