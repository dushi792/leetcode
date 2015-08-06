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
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        if (root == null)
            return res;
        
        que.offer(root);
        
        while(!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = que.poll();
                if (i == 0) res.add(curr.val);
                if (curr.right != null) que.offer(curr.right);
                if (curr.left != null) que.offer(curr.left);
            }
        }
        return res;
    }
}