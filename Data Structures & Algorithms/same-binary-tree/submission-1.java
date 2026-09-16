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
        Queue<TreeNode> q1 = new ArrayDeque<>();
        Queue<TreeNode> p1 = new ArrayDeque<>();

        if(p==null && q==null)
        return true;
        else if(p == null || q==null)
        return false;

        q1.offer(q);
        p1.offer(p);

        while(!q1.isEmpty()) {
            int size = q1.size();
            for(int i = 0 ; i<size;i++) {
                TreeNode cq = q1.poll();
                TreeNode cp = p1.poll();

                if(cq.val!=cp.val)
                return false;

                if(cq.left != null && cp.left != null) {
                    q1.offer(cq.left);
                    p1.offer(cp.left);
                }
                else if(cq.left==null && cp.left==null); 
                else return false;

                if(cq.right != null && cp.right != null) {
                    q1.offer(cq.right);
                    p1.offer(cp.right);
                }
                else if(cq.right==null && cp.right==null); 
                else return false;
                
            }
        }
        return q1.size() == p1.size();
}
}   