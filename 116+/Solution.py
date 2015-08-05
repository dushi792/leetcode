# Definition for binary tree with next pointer.
# class TreeLinkNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
#         self.next = None

class Solution:
    # @param root, a tree link node
    # @return nothing
    def connect(self, root):
        if root is None or root.left is None:
            return
        
        start = root;
        root.left.next = root.right
        while root.next is not None:
            root.right.next = root.next.left
            root = root.next
            if root.left is not None:
                root.left.next = root.right
        
        self.connect(start.left)