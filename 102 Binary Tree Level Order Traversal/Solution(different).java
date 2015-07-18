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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null)
            return result;
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root);
        
        while (!que.isEmpty()) {
            int n = que.size();
            List<Integer> levelresult = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                TreeNode peek = que.poll();
                levelresult.add(peek.val);
                if (peek.left != null)
                    que.offer(peek.left);
                if (peek.right != null)
                    que.offer(peek.right);
            }
            result.add(levelresult);
        }
        return result;
    }
}