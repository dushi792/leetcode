public class Solution {
    private TreeNode curt;
    private Stack<TreeNode> stack = new Stack<TreeNode>();
    //@param root: The root of binary tree.
    public Solution(TreeNode root) {
        curt = root;
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        return curt != null || !stack.isEmpty();
    }

    //@return: return next node
    public TreeNode next() {
        while (curt != null) {
            stack.push(curt);
            curt = curt.left;
        }
        curt = stack.peek().right;
        return stack.pop();
    }
}
