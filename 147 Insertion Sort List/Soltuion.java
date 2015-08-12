/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        // ***Linked list必备技巧：构造空头结点
        ListNode helper = new ListNode(0);
        ListNode pre = helper;
        ListNode cur = head;

        while (cur != null) {
            //XXX错误：while (pre.next != null && cur.val > pre.val && cur.val > pre.next.val) {
            while (pre.next != null && cur.val > pre.next.val) {
                pre = pre.next;
            }
            ListNode temp = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = temp;
            pre = helper;
        }
        return helper.next;
    }
}
