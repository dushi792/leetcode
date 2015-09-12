public class Solution {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        while (head.next != null && head.next.next != null) {
            if (head.next.val == head.next.next.val) {
                int value = head.next.val;
                // while循环不要漏了head.next != null
                while (head.next != null && head.next.val == value) {
                    head.next = head.next.next;
                }
            }
            else {
                head = head.next;
            }
        }

        return dummy.next;
    }
}


// Old
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
