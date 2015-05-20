# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param head, a ListNode
    # @return a boolean
    def hasCycle(self, head):
        fast = head
        while fast is not None and fast.next is not None and fast.next.next is not None :
            fast = fast.next.next
            head = head.next
            if fast == head:
                return True
        return False