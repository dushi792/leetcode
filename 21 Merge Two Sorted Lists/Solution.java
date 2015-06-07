/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;
        else if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;
            
        ListNode result, root;
        
        if (l1.val < l2.val) {
            result = l1;
            l1 = l1.next;
        }
        else {
            result = l2;
            l2 = l2.next;
        }
        root = result;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                result.next = l1;
                result = result.next;
                l1 = l1.next;
            }
            else {
                result.next = l2;
                result = result.next;
                l2 = l2.next;
            }
        }
        
        if (l1 != null)
            result.next = l1;
        else
            result.next = l2;
            
        return root;
    }
}