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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        int len = nums.length;
        TreeNode root = new TreeNode(nums[len/2]);
        //if (len/2-1 >= 0)
            root.left = sortedArrayToBST(Arrays.copyOfRange(nums,0,len/2));
        //if (len/2+1 <= len-1)
            root.right = sortedArrayToBST(Arrays.copyOfRange(nums,len/2+1,len));
        return root;
    }
}