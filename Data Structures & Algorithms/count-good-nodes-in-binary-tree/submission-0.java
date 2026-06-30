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
    int count = 0;
    public int goodNodes(TreeNode root) {
        helper(root, Integer.MIN_VALUE);
        return count;
    }

    private int helper(TreeNode node, int maxSoFar) {
        if (node == null) {
            return 0;
        }

        if (node.val >= maxSoFar) {
            count++;
        }

        maxSoFar = Math.max(node.val, maxSoFar);

        return helper(node.left, maxSoFar) + helper(node.right, maxSoFar);
    }
}
