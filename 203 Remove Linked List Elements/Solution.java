public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode top = new ListNode(0);
        top.next = head;
        ListNode pre = top;
        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
            }
            else {
                pre = head;
            }
            head = head.next;
        }
        return top.next;
    }
}
