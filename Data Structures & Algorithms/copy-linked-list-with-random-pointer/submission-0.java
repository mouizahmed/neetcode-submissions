/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        
        Node dummy = head;
        while (dummy != null) {
            map.put(dummy, new Node(dummy.val));
            dummy = dummy.next;
        }

        Node start = new Node(0);
        Node cur = map.get(head);
        start.next = cur;
        while (head != null) {
            cur.val = head.val;
            cur.random = map.get(head.random);
            cur.next = map.get(head.next);

            cur = cur.next;
            head = head.next;
        }


        return start.next;
    }
}
