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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> p1 = new ArrayDeque<>();
        Queue<TreeNode> q1 = new ArrayDeque<>();

        if(p==null && q==null)
        return true;
        if(p==null || q==null)
        return false;

        p1.offer(p);
        q1.offer(q);

        while(!p1.isEmpty() && !q1.isEmpty()) {
            TreeNode cp = p1.poll();
            TreeNode cq = q1.poll();

            if(cp.val!=cq.val) 
            return false;

            if(cp.right!=null && cq.right!=null) {
                p1.offer(cp.right);
                q1.offer(cq.right);
            }
            else if(cp.right==null && cq.right==null);
            else 
            return false;

            if(cq.left != null && cp.left != null) {
                    q1.offer(cq.left);
                    p1.offer(cp.left);
                }
            else if(cq.left==null && cp.left==null); 
            else return false;

        }
        return q1.size()==p1.size();
    }
}   