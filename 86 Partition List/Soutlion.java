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
      //常用技巧：在头指针位置先插入一个干扰元素，以保证head永不为空，然后在最后返回的时候删除掉。
        ListNode smallhead = new ListNode(0);
        ListNode largehead = new ListNode(0);
        ListNode small = smallhead;
        ListNode large = largehead;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                small.next = curr;
                small = small.next;
                curr = curr.next;
            }
            else {
                large.next = curr;
                large = large.next;
                curr = curr.next;
            }
        }
        large.next = null;
        small.next = largehead.next;
        return smallhead.next;
    }
}
