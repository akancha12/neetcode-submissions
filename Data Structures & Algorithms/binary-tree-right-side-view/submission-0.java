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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        LinkedList<TreeNode> levels = new LinkedList<>();
        levels.add(root);

        while(!levels.isEmpty()) {
            int n = levels.size();
            TreeNode rightMostNode = levels.getLast();
            result.add(rightMostNode.val);
            for (int i=0; i<n; i++) {
                TreeNode node = levels.pollFirst();
                if (node.left != null) levels.add(node.left);
                if (node.right!=null) levels.add(node.right);
            }
        }
        return result;
    }
}
