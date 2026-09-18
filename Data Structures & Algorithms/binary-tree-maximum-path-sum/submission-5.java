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
        return dfs(root)[1];

    }

    public int[] dfs(TreeNode root) {
        if(root==null) 
        return new int[] {0, Integer.MIN_VALUE / 2};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        left[0]=Math.max(0,left[0]);
        right[0]=Math.max(0,right[0]);
        int[] ans = new int[2];
        int max = Math.max(left[0],right[0]);
        max = Math.max(0,max);
        
        ans[0] = root.val+max;

        ans[1] = Math.max(left[1],right[1]);
        ans[1] = Math.max(ans[1] , root.val+left[0]+right[0]);

        return ans;
        
    }
}
