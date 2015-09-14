// 优化结构
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    private ListNode curr;

    private int getLength(ListNode head) {
        int length = 0;

        while (head != null) {
            length++;
            head = head.next;
        }

        return length;
    }

    private TreeNode helper(int size) {
        if (size <= 0) {
            return null;
        }

        TreeNode left = helper(size / 2);
        TreeNode root = new TreeNode(curr.val);
        curr = curr.next;
        TreeNode right = helper(size - 1 - size / 2);

        root.left = left;
        root.right = right;

        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        curr = head;
        int size = getLength(head);

        return helper(size);
    }
}


// Old version
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
