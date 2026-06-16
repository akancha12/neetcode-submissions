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
    int counter;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        counter = k;
        return traverse(root);        
    }
    public int traverse(TreeNode root) {
        if (root == null || counter==0) return -1;
        int a = traverse(root.left);
        if (a != -1) return a;
        counter--;
        if (counter==0) return root.val;
        int b = traverse(root.right);
        if (b!=-1) return b;
        return -1;
    }
}
