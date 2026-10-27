/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        HashMap<Node, Node> copies = new HashMap<>();

        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        copies.put(node, new Node(node.val));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (Node n : cur.neighbors) {
                if (!copies.containsKey(n)) {
                    Node copy = new Node(n.val);
                    copies.put(n, copy);
                    q.add(n);
                }

                copies.get(cur).neighbors.add(copies.get(n));
                
            }
        }

        return copies.get(node);
        
    }
}