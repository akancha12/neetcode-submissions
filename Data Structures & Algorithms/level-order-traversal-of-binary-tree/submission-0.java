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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> traverse = new LinkedList<>();
        traverse.add(root);
        while (!traverse.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int n = traverse.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = traverse.poll();
                level.add(node.val);
                if (node.left != null)
                    traverse.add(node.left);
                if (node.right != null)
                    traverse.add(node.right);
            }
            result.add(level);
        }
        return result;
    }
}
