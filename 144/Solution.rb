# Definition for a binary tree node.
# class TreeNode
#     attr_accessor :val, :left, :right
#     def initialize(val)
#         @val = val
#         @left, @right = nil, nil
#     end
# end

# @param {TreeNode} root
# @return {Integer[]}
def preorder_traversal(root)
    if root.nil?
        return []
    end
    
    result = []
    stack = [root]
    while !stack.empty?
        visit = stack.pop
        result.push(visit.val)
        if !visit.right.nil?
            stack.push(visit.right)
        end
        if !visit.left.nil?
            stack.push(visit.left)
        end
    end
    return result
end