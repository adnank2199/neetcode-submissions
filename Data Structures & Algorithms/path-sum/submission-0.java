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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)
        return false;

        int res = targetSum - root.val ;
        
        if(root.right == null && root.left == null && res==0)
        return true;
        if(hasPathSum(root.left,res))
        return true;
        if(hasPathSum(root.right,res))
        return true;

        return false ;

    }
}