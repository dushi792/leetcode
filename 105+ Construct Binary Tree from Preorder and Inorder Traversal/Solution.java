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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, 0, inorder.length-1);
    }
    private TreeNode helper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        // if判断条件还需要复习
        if (preStart > preorder.length-1 || inEnd < inStart) return null;
        int index = 0;
        for (int i = inStart; i < inorder.length; i++) {
            if (preorder[preStart] == inorder[i]) index = i;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        root.left = helper(preorder, inorder, preStart+1, inStart, index-1);
        // Why preStart-inStart+index+1?
        // preStart-inStart = preEnd - inEnd = 偏移量（offset）
        // 比如 先序 1 2 4 5 3 6 7
        //     中序 4 2 5 1 6 3 7
        // 当分解到   2 4 5
        //         4 2 5   时，
        // 2是index, 5是index+1，如果 2 4 5 和 4 2 5 上下对齐的话，对于root.right的先序来讲
        // preStart= index+1，但是现在并不对齐，preorder和inorder之间差 1 = preStart - inStart,
        // 所以再上这部分偏移量
        //
        // 理解2： 其实preStart-inStart+index+1 就是 preEnd - (inEnd - postiton) + 1
        // 从后往前看
        root.right = helper(preorder, inorder, preStart-inStart+index+1, index+1, inEnd);
        return root;
    }
}
