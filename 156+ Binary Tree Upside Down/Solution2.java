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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return root;
        TreeNode lf = root.left;
        TreeNode rt = root.right;
        
        root.left = root.right = null;
        
        while (lf != null) {
            TreeNode newleft = lf.left;
            TreeNode newright = lf.right;
            lf.left = rt;
            lf.right = root;
            root = lf;
            lf = newleft;
            rt = newright;
        }
        return root;
    }
}