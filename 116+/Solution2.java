/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution2 {
    public void connect(TreeLinkNode root) {
        TreeLinkNode current;
        TreeLinkNode parent = root;
        while (parent != null && parent.left != null) {
            current = parent;
            current.left.next = current.right;
            while (current.next != null) {
                current.right.next = current.next.left;
                current = current.next;
                if (current.left != null)
                    current.left.next = current.right;
            }
            parent = parent.left;
        }
    }
}