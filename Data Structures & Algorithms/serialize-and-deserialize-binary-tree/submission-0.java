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
        List<String> res = new ArrayList<>();
        serializeDFS(root, res);

        return String.join(",", res);        
    }

    private void serializeDFS(TreeNode root, List<String> res) {
        if (root == null) {
            res.add("null");
            return;
        }

        res.add(String.valueOf(root.val));
        serializeDFS(root.left, res);
        serializeDFS(root.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        Queue<String> q = new ArrayDeque<>(Arrays.asList(vals));
        return deserializeDFS(q);
    }

    private TreeNode deserializeDFS(Queue<String> q) {
        String val = q.poll();
        if (val.equals("null")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserializeDFS(q);
        node.right = deserializeDFS(q);

        return node;
    }


}
