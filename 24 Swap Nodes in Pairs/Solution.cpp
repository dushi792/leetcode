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
    ListNode* swapPairs(ListNode* head) {
        if (head == NULL || head->next == NULL)
            return head;
        
        ListNode* helper;
        helper->next = head;
        ListNode* pre = helper;
        ListNode* cur = head;
        
        while (cur != NULL && cur->next != NULL) {
            ListNode* next = cur->next->next;
            cur->next->next = cur;
            pre->next = cur->next;
            cur->next = next;
            pre = cur;
            cur = next;
        }
        return helper->next;
    }
};


//recursive
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
    ListNode* swapPairs(ListNode* head) {
        if (head == NULL || head->next == NULL)
            return head;
        
        ListNode* next = head->next;
        head->next = swapPairs(next->next);
        next->next = head;
        return next;
    }
};