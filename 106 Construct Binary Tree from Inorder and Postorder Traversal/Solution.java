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
    // 跟之前一道不太一样，这道题inorder,postorder各有2个头未标记，一共用了4个头尾标记
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, 0, postorder.length-1, 0, inorder.length-1);
    }
    private TreeNode helper(int[] inorder, int[] postorder, int postStart, int postEnd, int inStart, int inEnd) {
        if (postStart > postEnd || inStart > inEnd) return null;
        int idx = 0;
        // for (int i = postEnd; i >= 0; i--)
        // 应该从Instart开始
        for (int i = inStart; i < inorder.length; i++) {
            if (postorder[postEnd] == inorder[i]) idx = i;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        root.left = helper(inorder, postorder, postStart, postEnd-inEnd+idx-1, inStart, idx-1);
        root.right = helper(inorder, postorder, postEnd-(inEnd-idx), postEnd-1, idx+1, inEnd);
        return root;
    }
}
