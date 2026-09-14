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
    public TreeNode deleteNode(TreeNode root, int val) {
        if(root==null)
        return null; 
        
        if(root.val < val) 
        root.right = deleteNode(root.right , val);
        else if(root.val > val) 
        root.left = deleteNode(root.left , val);
        else { 
            if(root.left == null )
            return root.right;
            else if (root.right == null)
            return root.left;
            else {
                int min = getMin(root.right);
                root.val = min ; 
                root.right = deleteNode(root.right , min);
            }
        }
        return root;
    }

    public int getMin(TreeNode root) { 
        TreeNode curr = root;
        while(curr!= null && curr.left!=null) {
            curr=curr.left;
        }
        return curr.val;
    }
}