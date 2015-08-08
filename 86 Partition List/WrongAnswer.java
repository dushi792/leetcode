/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;

        ListNode small = null;
        ListNode large = null;
        ListNode smallhead = null;
        ListNode largehead = null;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                if (small == null) {
                    small = curr;
                    smallhead = small;
                }
                else {
                    small.next = curr;
                    small = small.next;
                    curr = curr.next;
                }
            }
            else {
                if (large == null) {
                    large = curr;
                    largehead = large;
                }
                else {
                    large.next = curr;
                    large = large.next;
                    curr = curr.next;
                }
            }
        }
        large.next = null;
        small.next = largehead;
        return small;
    }
}
