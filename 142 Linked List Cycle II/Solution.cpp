/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        if (!head)
            return NULL;
        ListNode* fast = head;
        ListNode* slow = head;
        
        while (true) {
            if (fast->next == NULL || fast->next->next == NULL)
                return NULL;
                
            fast = fast->next->next;
            slow = slow->next;
            if (slow == fast)
                break;
        }
		fast = head;
        while (fast != slow) {
            fast = fast->next;
            slow = slow->next;
        }
        return fast;
    }
};