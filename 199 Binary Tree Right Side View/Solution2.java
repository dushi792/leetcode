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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helpRight(root, res, 0);
        return res;
    }
    private void helpRight(TreeNode root, List<Integer> res, int level) {
        if (root == null) return;
        
        if (level == res.size()) {
            res.add(root.val);
        }
        
        if (root.right != null) helpRight(root.right, res, level+1);
        if (root.left != null) helpRight(root.left, res, level+1);
        
    }
}