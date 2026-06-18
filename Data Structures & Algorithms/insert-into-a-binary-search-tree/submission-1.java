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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode temp = root;
        TreeNode node = new TreeNode(val);
        if (root == null) return node;
        while (temp!=null) {
            if (val < temp.val) {
                if (temp.left == null) {
                    temp.left = node;
                    break;
                } else {
                    temp = temp.left;
                }
            }
            else if (val > temp.val) {
                if (temp.right == null) {
                    temp.right = node;
                    break;
                } else {
                    temp = temp.right;
                }
            }
        }
        return root;
    }
}