// HashMap Solution
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode curr = head;
        
        while (curr != null) {
            RandomListNode newNode = new RandomListNode(curr.label);
            map.put(curr, newNode);
            curr = curr.next;
        }
        
        curr = head;
        while (curr != null) {
            RandomListNode node = map.get(curr);
            node.next = map.get(curr.next);
            node.random = map.get(curr.random);
            curr = curr.next;
        }
        
        return map.get(head);
    }
}

// HashMap一次循环（不推荐）：
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode tail = dummy;
        RandomListNode newNode;
        
        while (head != null) {
            if (map.containsKey(head)) {
                newNode = map.get(head);
            }
            else {
                newNode = new RandomListNode(head.label);
                map.put(head, newNode);
            }
            tail.next = newNode;
            
            // 务必记得判断head.random != null, 否则空指针错误
            if (head.random != null) {
                if (map.containsKey(head.random)) {
                    newNode.random = map.get(head.random);
                }
                else {
                    newNode.random = new RandomListNode(head.random.label);
                    map.put(head.random, newNode.random);
                }
            }
            
            tail = tail.next;
            head = head.next;
        }
        
        return dummy.next;
    }
}
// A soultion with O(1) extra space
public class Solution {
    private void copyNext(RandomListNode head) {
        while (head != null) {
            RandomListNode newNode = new RandomListNode(head.label);
            RandomListNode temp = head.next;
            head.next = newNode;
            newNode.next = temp;
            head = temp;
        }
    }
    
    private void copyRandom(RandomListNode head) {
        while (head != null) {
            if (head.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }
    
    // private RandomListNode split(RandomListNode head) {
    //     RandomListNode dummy = new RandomListNode(0);
    //     RandomListNode tail = dummy;
        
    //     while (head != null) {
    //         tail.next = head.next;
    //         head = head.next.next;
    //         tail = tail.next;
    //     }
        
    //     return dummy.next;
    // }
    // 重写了以上方法，只用一个空间
    private RandomListNode split(RandomListNode head) {
        RandomListNode newHead = head.next;
        
        while (head != null) {
            RandomListNode temp = head.next;
            head.next = temp.next;
            head = head.next;
            if (temp.next != null) {
                temp.next = head.next;
            }
        }
        
        return newHead;
    }
    
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        
        copyNext(head);
        copyRandom(head);
        return split(head);
    }
}
