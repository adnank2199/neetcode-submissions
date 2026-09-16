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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root,p,q)[0];
    }

    public TreeNode[] helper(TreeNode root , TreeNode p , TreeNode q) {
        if(root==null)
        return new TreeNode[] {null,null};

        TreeNode[] left = helper(root.left,p,q);
        TreeNode[] right = helper(root.right,p,q);


        //Sceanario 0 : solution is found 
        if(left[0]!=null && left[1]==null) return left ;
        if(right[0]!=null && right[1]==null) return right ; 

        //Scenario 1 : one number is found on the left and right branches 
        if(left[1]!=null && right[1]!=null)
        return new TreeNode[] {root,null} ;
        
        //Scenario 2 : one of the numbers is the root itself and the other number in the branches 
        TreeNode found = (root.val == p.val || root.val == q.val ) ? root : null ;


        if((left[1]!=null || right[1]!=null) && found!=null) 
        return new TreeNode[] {found , null};

        if(found!=null)
        return new TreeNode[] {null,found};

        //Scenario 3 : only the number is found in the branches 
        if(left[1]!=null) return new TreeNode[] {null,left[1]};
        if(right[1]!=null) return new TreeNode[] {null,right[1]};

        //Scenario 4 : nothing is found anywhere 
        return new TreeNode[] {null,null};
    }
}
