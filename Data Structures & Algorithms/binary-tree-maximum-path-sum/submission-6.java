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
    public int maxPathSum(TreeNode root) {
        return helper(root)[0];
    }

    public int[] helper(TreeNode root) {
        if(root==null)
        return new int[] {Integer.MIN_VALUE/2,Integer.MIN_VALUE};

        int[] left = helper(root.left);
        int[] right = helper(root.right);
        
        int leftMax = Math.max(0,left[1]);
        int rightMax = Math.max(0,right[1]);

        int max = Math.max(left[0],right[0]);
        max = Math.max(leftMax+rightMax+root.val , max);

        return new int[] {max,root.val + Math.max(leftMax,rightMax)};
    }
}
