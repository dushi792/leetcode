# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param {TreeNode} root
    # @return {integer}
    def max(self, a, b):
        return a if a > b else b
    def maxDepth(self, root):
        return 0 if not root else max(self.maxDepth(root.left),self.maxDepth(root.right))+1;
