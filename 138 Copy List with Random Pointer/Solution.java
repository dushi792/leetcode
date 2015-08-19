// Common Solution
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return head;
        HashMap<RandomListNode, RandomListNode> map = new
        HashMap<RandomListNode, RandomListNode>();
        RandomListNode newHead = new RandomListNode(head.label);
        RandomListNode pre = newHead;
        map.put(head, newHead);
        RandomListNode node = head.next;
        while (node != null) {
            RandomListNode newNode = new RandomListNode(node.label);
            map.put(node, newNode);
            pre.next = newNode;
            pre = newNode;
            node = node.next;
        }
        node = head;
        pre = newHead;
        while (node != null) {
            pre.random = map.get(node.random);
            pre = pre.next;
            node = node.next;
        }
        return newHead;
    }
}
// A soultion with O(1) extra space
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return head;
        RandomListNode iter = head;
        while (iter != null) {
            RandomListNode next = iter.next;
            RandomListNode node = new RandomListNode(iter.label);
            iter.next = node;
            node.next = next;
            iter = next;
        }
        iter = head;
        while (iter != null) {
            if (iter.random != null)
                iter.next.random = iter.random.next;
            iter = iter.next.next;
        }
        iter = head;
        RandomListNode newHead = head.next;
        while (iter != null) {
          // 操作需要注意
            RandomListNode next = iter.next;
            iter.next = next.next;
            if (next.next != null)
                next.next = next.next.next;
            iter = iter.next;
        }
        return newHead;
    }
}
