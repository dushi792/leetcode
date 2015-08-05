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
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        if (headA == NULL || headB == NULL)
            return NULL;
            
        ListNode *pointA = headA;
        ListNode *pointB = headB;
        
        while (pointA || pointB) {
            if (pointA == pointB)
                return pointA;
            
            pointA = pointA->next;
            pointB = pointB->next;
            if (!pointA && !pointB)
                break;
            if (!pointA)
                pointA = headB;
            if (!pointB)
                pointB = headA;
        }
        return NULL;
    }
};