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
    public int kthSmallest(TreeNode root, int k) {
        return dfs(root,k)[0];
    }

    public int[] dfs(TreeNode root , int k) {
        if(root==null)
        return new int[]{0,k};

        int[] left = dfs(root.left , k);
        if(left[1]==0)
        return left;
        int curr = left[1]-1;
        if(curr==0)
        return new int[]{root.val , curr};
        int[] right = dfs(root.right , curr);
        return right; 
    }
}
