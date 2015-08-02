/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    private ListNode node;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        node = head;
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        
        return helper(0, count-1);
    }
    
    private TreeNode helper(int l, int r) {
        if (l > r)
            return null;
        int mid = (l + r) / 2;
        TreeNode left = helper(l, mid - 1);
        TreeNode root = new TreeNode(node.val);
        root.left = left;
        node = node.next;
        
        TreeNode right = helper(mid+1, r);
        root.right = right;
        
        return root;
    }
}