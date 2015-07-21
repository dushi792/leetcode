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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new LinkedList<TreeNode>();
        //不能是helper(0, n);
        result = helper(1, n);
        return result;
    }
    
    private List<TreeNode> helper(int min, int max) {
        List<TreeNode> res = new LinkedList<TreeNode>();
        if (min > max) {
            //不是很理解
            res.add(null);
            return res;
        }
            
        for (int i = min; i <= max; i++) {
            List<TreeNode> leftList = helper(min, i-1);
            List<TreeNode> rightList = helper(i+1, max);
            for (int j = 0; j < leftList.size(); j++) {
                for (int k = 0; k < rightList.size(); k++) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftList.get(j);
                    root.right = rightList.get(k);
                    res.add(root);
                }
            }
        }
        return res;
    }
}