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
    public int goodNodes(TreeNode root) {
        return dfs(root,root.val);
    }

    public int dfs(TreeNode root , int max) {
        if(root==null)
        return 0;

        int left = dfs(root.left,Math.max(max,root.val));
        int right = dfs(root.right,Math.max(max,root.val));
        int curr = max > root.val ? 0 : 1 ;

        return left + right + curr;
    }
}
