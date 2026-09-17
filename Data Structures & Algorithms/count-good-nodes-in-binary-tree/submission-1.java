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

    public int dfs(TreeNode root, int prevMax) {
        if(root==null)
        return 0;
        int ans = (root.val >= prevMax) ? 1 : 0 ;
        prevMax = (root.val > prevMax) ? root.val : prevMax ; 

        int left = dfs(root.left,prevMax);
        int right = dfs(root.right,prevMax);

        return ans+left+right;
    }
}
