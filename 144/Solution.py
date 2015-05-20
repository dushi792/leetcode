# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param {TreeNode} root
    # @return {integer[]}
    def preorderTraversal(self, root):
        if root is None:
            return []
        result = []
        stack = [root]
        while stack:
            visit = stack.pop()
            result.append(visit.val)
            if visit.right:
                stack.append(visit.right)
            if visit.left: 
                stack.append(visit.left)
        return result