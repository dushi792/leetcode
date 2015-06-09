/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null)  
            return null;  
        ListNode helper = new ListNode(0);  
        helper.next = head;  
        ListNode pre = helper;  
        ListNode cur = head;  
        while(cur!=null && cur.next!=null)  
        {  
            ListNode next = cur.next.next;  
            cur.next.next = cur;  
            pre.next = cur.next;
            
            cur.next = next;  
            pre = cur;  
            cur = next;  
        }  
        return helper.next;
    }
}