// Solution1:
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        int count = 0;
        while (fast.next != null) {
            fast = fast.next;
            count++;
        }
        
        k = k % count;
        ListNode slow = dummy;
        for (int i = count - k; i > 0; i--) {
            slow = slow.next;
        }
        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
               
        return dummy.next;
    }
}
// Solution2:
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode node = head;
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        k = k % length;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        ListNode tail = dummy;
		// 让head和tail始终相差k个位置
        for (int i = 0; i < k; i++) {
            head = head.next;
        }
        while (head.next != null) {
            head = head.next;
            tail = tail.next;
        }
        
        head.next = dummy.next;
        dummy.next = tail.next;
        tail.next = null;
               
        return dummy.next;
    }
}