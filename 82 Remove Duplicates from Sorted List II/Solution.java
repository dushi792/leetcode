public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode top = new ListNode(0);
        top.next = head;
        ListNode curr = head;
        ListNode pre = top;
        while (curr != null) {
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }
            // if else 条件还需要自己再推导下
            if (pre.next == curr)
                pre = pre.next;
            else
                pre.next = curr.next;
            curr = curr.next;
        }
        return top.next;
    }
}
