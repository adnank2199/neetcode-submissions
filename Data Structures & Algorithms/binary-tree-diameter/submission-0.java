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
    public int diameterOfBinaryTree(TreeNode root) {
        return dfs(root)[1];
    }

    public int[] dfs(TreeNode root) {
        if(root==null)
        return new int[] {0,0};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int max = Math.max(left[1],right[1]);
        int leftmax=left[0] , rightmax=right[0];
        if(root.left!=null)
        leftmax++;
        if(root.right!=null)
        rightmax++;
        max = Math.max(leftmax+rightmax , max);

        return new int[] {Math.max(leftmax,rightmax),max};



    }
}
