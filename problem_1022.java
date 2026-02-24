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
    private int func(TreeNode root, int curr) {
        if (root == null) return 0;

        curr = (curr << 1) | root.val;

        if (root.left == null && root.right == null)
            return curr;

        return func(root.left, curr) + func(root.right, curr);
    }

    public int sumRootToLeaf(TreeNode root) {
        return func(root, 0);
    }
}