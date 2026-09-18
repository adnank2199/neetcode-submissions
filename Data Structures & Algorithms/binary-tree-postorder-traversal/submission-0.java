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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        Stack<Boolean> v = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        s.push(root);
        v.push(false);
        while(!s.isEmpty()) {
            TreeNode curr = s.pop();
            boolean visited = v.pop();

            if(curr!=null) {
                if(visited) {
                    ans.add(curr.val);
                }
                else {
                    s.push(curr);
                    v.push(true);
                    s.push(curr.right);
                    v.push(false);
                    s.push(curr.left);
                    v.push(false);
                }
            }

        }
        return ans;
    }
}