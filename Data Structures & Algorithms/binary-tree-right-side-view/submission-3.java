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
    public List<Integer> rightSideView(TreeNode root) {

        if(root==null)
        return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();

        q.offer(root);

        ans.add(q.peekLast().val);

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i =0;i<size;i++) {
                TreeNode curr = q.poll();
                if(curr.left!=null)
                q.offer(curr.left);
                if(curr.right!=null)
                q.offer(curr.right);
                
            }
            if(!q.isEmpty())
            ans.add(q.peekLast().val);

        }
        return ans;
    }
}
