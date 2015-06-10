/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
//iterative
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        if (head == NULL || head->next == NULL)
            return head;
            
        ListNode* pre = NULL;
        ListNode* next = NULL;
        
        while (head != NULL) {
            next = head->next;
            head->next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
};
//recursive
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        if (head == NULL || head->next == NULL)
            return head;
            
        ListNode* temp = head->next;
        head->next = NULL;
        ListNode* newhead = reverseList(temp);
        temp->next = head;
        
        return newhead;
    }
};