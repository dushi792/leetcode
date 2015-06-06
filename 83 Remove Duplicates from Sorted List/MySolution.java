/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        ListNode deldup = head;
        while (deldup != null) {
            while (deldup.next != null && deldup.val == deldup.next.val) {
                deldup.next = deldup.next.next;
            }
            deldup = deldup.next;
        }
        return head;
    }
}