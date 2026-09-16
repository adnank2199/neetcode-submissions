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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null)
        return false;

        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot) || same(root,subRoot);

    }

    public boolean same(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null)
        return true;
        else if(root1==null || root2==null)
        return false;
        


        Queue<TreeNode> r1 = new ArrayDeque<>();
        Queue<TreeNode> r2 = new ArrayDeque<>();
        r1.offer(root1);
        r2.offer(root2);
        while(!r1.isEmpty()) {

            int size = r1.size();
            for(int i =0 ; i< size;i++) {
                TreeNode curr1 = r1.poll();
                TreeNode curr2 = r2.poll();

                if(curr2.val != curr1.val)
                return false; 

                if(curr1.left !=null && curr2.left !=null) {
                    r1.offer(curr1.left);
                    r2.offer(curr2.left);
                }
                else if(curr1.left==null && curr2.left==null);
                else 
                return false;

                if(curr1.right !=null && curr2.right !=null) {
                    r1.offer(curr1.right);
                    r2.offer(curr2.right);
                }
                else if(curr1.right==null && curr2.right==null);
                else 
                return false;

            }

        }
    
        return r1.size()==r2.size();
    }
}
