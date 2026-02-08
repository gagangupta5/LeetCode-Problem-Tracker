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
    public boolean isBalanced(TreeNode root) {
        return heightdfs(root) != -1;
    }

    private int heightdfs(TreeNode root){
        if(root==null) return 0;
        int lheight=heightdfs(root.left);
        if(lheight==-1) return -1;
        int rheight=heightdfs(root.right);
        if(rheight==-1) return -1;
        if(Math.abs(lheight-rheight)>1) return -1;
        return 1+Math.max(lheight,rheight);
    }
}