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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> h = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        h.put(inorder[i],i);
        return dfs(preorder  ,0, preorder.length-1,0,inorder.length-1,  h);
    }

    public TreeNode dfs(int[] preorder , int ps , int pe, int is , int ie  , Map<Integer,Integer> h) {
        if(pe<ps || ie < is)
        return null;

        int index = h.get(preorder[ps]);

        TreeNode left = dfs(preorder , ps+1 , ps + index-is, is , index-1 ,h);
        TreeNode right = dfs(preorder,  ps  + index - is + 1  , pe , index+1 , ie ,h);

        TreeNode root = new TreeNode(preorder[ps]);
        root.left = left;
        root.right = right ;

        return root;
    }
}