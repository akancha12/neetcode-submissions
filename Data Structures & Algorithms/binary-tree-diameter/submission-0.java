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
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxHeight(root);
        return ans;
    }
    public int maxHeight(TreeNode root) {
        if (root == null) return 0;
        int l = maxHeight(root.left);
        int r = maxHeight(root.right);
        int diameter = l+r;
        ans = Math.max(ans, diameter);
        return 1 + Math.max(l, r);
    }
}
