/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        return leftHeight>rightHeight ? leftHeight+1 : rightHeight+1;
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(maxDepth(root.left)-maxDepth(root.right) > 1 || maxDepth(root.right)-maxDepth(root.left) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
}