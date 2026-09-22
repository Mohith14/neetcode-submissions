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
    int maxDiameter =0;
    public int diameterOfBinaryTree(TreeNode root) {
       calDiam(root);

       return maxDiameter;
        
    }
    private int calDiam(TreeNode root){
        if(root == null) return 0;

        int height_l = calDiam(root.left);
        int height_r = calDiam(root.right);

        int current_diam = height_l + height_r;

        maxDiameter =Math.max(current_diam, maxDiameter);
        return Math.max(height_l, height_r) + 1;
    }
}
