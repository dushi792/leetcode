/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null || root.left == null)
            return;
        
        TreeLinkNode start = root;
        root.left.next = root.right;
        while (root.next != null) {
            root.right.next = root.next.left;
            root = root.next;
            if (root.left != null) 
                root.left.next = root.right;
        }
        connect(start.left);
    }
}