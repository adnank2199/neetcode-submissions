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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> code = new ArrayList<>();
        dfsSerializer(root,code);
        return String.join(",",code);
    }

    public void dfsSerializer(TreeNode root , List<String> code) {
        if(root==null) {
            code.add("N");
            return;
        }
        code.add(String.valueOf(root.val));
        dfsSerializer(root.left,code);
        dfsSerializer(root.right,code);


    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] decode = data.split(",");
        int[] i = {0};
        return dfsDeserializer(decode,i);
    }
    
    public TreeNode dfsDeserializer(String[] decode,int[] i) {
        if(decode[i[0]].equals("N")) {
            i[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(decode[i[0]]));
        i[0]++;
        root.left = dfsDeserializer(decode,i);
        root.right = dfsDeserializer(decode,i);

        return root;

    }

    
}
