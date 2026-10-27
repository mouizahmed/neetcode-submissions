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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();

        if (root != null) {
            queue.add(root);
        }

        while(!queue.isEmpty()) {
            int levelLength = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < levelLength; i++) {
                TreeNode cur = queue.removeFirst();
                level.add(cur.val);

                if (cur.left != null) {
                    queue.add(cur.left);
                }

                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }

            res.add(level);
        }

        return res;
        

    }
}
