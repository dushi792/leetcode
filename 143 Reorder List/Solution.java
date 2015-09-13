public class Solution {
        private ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head.next;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
    
    private void merge(ListNode head1, ListNode head2) {
        // ListNode dummy = new ListNode(0);
        ListNode tail = new ListNode(0);
        int index = 1;
        
        while (head1 != null && head2 != null) {
            if (index % 2 == 1) {
                tail.next = head1;
                head1 = head1.next;
            }
            else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
            index++;
        }
        if (head1 != null) {
            tail.next = head1;
        }
        else {
            tail.next = head2;
        }
    }
    
    public void reorderList(ListNode head) {  
        if (head == null || head.next == null) {
            return;
        }
        
        ListNode middle = findMiddle(head);
        ListNode right = reverse(middle.next);
        // 不要漏掉，否则Memory Limit Exceeded
        middle.next = null;
        
        merge(head, right);
    }
}