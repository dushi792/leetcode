/**
 * Definition for binary tree with next pointer.
 * function TreeLinkNode(val) {
 *     this.val = val;
 *     this.left = this.right = this.next = null;
 * }
 */

/**
 * @param {TreeLinkNode} root
 * @return {void} Do not return anything, modify tree in-place instead.
 */
var connect = function(root) {
    if (root === null || root.left === null)
            return;
        
        start = root;
        root.left.next = root.right;
        while (root.next !== null) {
            root.right.next = root.next.left;
            root = root.next;
            if (root.left !== null) 
                root.left.next = root.right;
        }
        connect(start.left);
};