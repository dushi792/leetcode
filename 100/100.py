# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param {TreeNode} p
    # @param {TreeNode} q
    # @return {boolean}
    def isSameTree(self, p, q):
        if not p and not q:
            return True;
        elif not p or not q or p.val != q.val:
            return False;
        return (self.isSameTree(p.left,q.left) and self.isSameTree(p.right,q.right));