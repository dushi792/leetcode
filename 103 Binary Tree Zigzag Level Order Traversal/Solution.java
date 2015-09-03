// 还应该尝试一下用stack解决
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        helper(root, res, 0);
        return res;
    }
    private void helper(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) return;
        if (res.size() == level) res.add(new LinkedList<Integer>());
        if (level%2 == 0) res.get(level).add(root.val);
        if (level%2 == 1) res.get(level).add(0, root.val);
        helper(root.left, res, level+1);
        helper(root.right, res, level+1);
    }
}

// 用Stack实现的iteration
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List result = new ArrayList();

        if (root == null) {
            return result;
        }
        int levelCount = 1;
        Stack<TreeNode> currLevel = new Stack<TreeNode>();
        Stack<TreeNode> nextLevel = new Stack<TreeNode>();
        currLevel.push(root);

        while (!currLevel.isEmpty()) {
            List<Integer> levelRes = new ArrayList<Integer>();

            while (!currLevel.isEmpty()) {
                TreeNode node = currLevel.pop();
                levelRes.add(node.val);
                if (levelCount % 2 == 0) {
                    if (node.right != null) {
                        nextLevel.push(node.right);
                    }
                    if (node.left != null) {
                        nextLevel.push(node.left);
                    }
                }
                else {
                    if (node.left != null) {
                        nextLevel.push(node.left);
                    }
                    if (node.right != null) {
                        nextLevel.push(node.right);
                    }
                }
            }
            result.add(levelRes);
            levelCount++;
            Stack<TreeNode> temp = currLevel;
            currLevel = nextLevel;
            nextLevel = temp;
        }
        return result;
    }
}
