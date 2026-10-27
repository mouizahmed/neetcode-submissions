class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.val = value;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    private final int capacity;
    private final Map<Integer, Node> map = new HashMap<>();
    Node left = new Node(0, 0); // least recently used
    Node right = new Node(0, 0); // last recently used

    public LRUCache(int capacity) {
        this.capacity = capacity;
        left.next = right;
        right.prev = left;
    }

    private void insert(Node node) {
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    } 

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;
        remove(node);
        insert(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
            map.remove(key);
        }

        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insert(newNode);

        if (map.size() > capacity) {
            // remove the least recently used node.
            Node lru = this.left.next;
            remove(lru);
            map.remove(lru.key);
        }
        
    }
}
