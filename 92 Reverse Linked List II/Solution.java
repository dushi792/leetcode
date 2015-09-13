// My Solution
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode top = new ListNode(0);
        top.next = head;
        ListNode curr = top;
        ListNode befStart = top;
        for (int i = 0; i < m; i++) {
            befStart = curr;
            curr = curr.next;
        }
        ListNode pre = befStart;
        ListNode next = null;
        for (int i = 0; i < n-m+1; i++) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        befStart.next.next = curr;
        befStart.next = pre;
        return top.next;
    }
}
// Review better one: https://leetcode.com/discuss/25580/simple-java-solution-with-clear-explanation
public ListNode reverseBetween(ListNode head, int m, int n) {
    if(head == null) return null;
    ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
    dummy.next = head;
    ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
    for(int i = 1; i < m; i++) {
      pre = pre.next;
    }

    ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
    ListNode then = start.next; // a pointer to a node that will be reversed

    // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
    // dummy-> 1 -> 2 -> 3 -> 4 -> 5

    for(int i=0; i<n-m; i++)
    {
        start.next = then.next;
        then.next = pre.next;
        pre.next = then;
        then = start.next;
    }

    // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
    // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)

    return dummy.next;

}
