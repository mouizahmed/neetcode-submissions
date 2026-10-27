public class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    private int cap;
    private HashMap<Integer, Node> cache;
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    private void insert(Node node) {
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    }

    private void remove(Node node) {
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insert(node);

            return node.val;
        }

        return -1;
    }

    public void put (int key, int value) {
        if (cache.containsKey(key)) remove(cache.get(key));

        Node node = new Node (key, value);
        insert(node);
        cache.put(key, node);

        if (cache.size() > cap) {
            Node lru = left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
    
    // public void put(int key, int value) {
    //     Node node = cache.get(key);

    //     if (node != null) {
    //         cache.remove(node);
    //         remove(node);
    //         node = new Node(key, value);
    //         insert(node);
    //         cache.put(key, node);

    //         return;
    //     }
        
    //     node = new Node(key, value);
    //     cache.put(key, node);
    //     insert(node);

    //     if (cache.size() > cap) {
    //         cache.remove(left.next.key);
    //         remove(left.next);
    //     }




    // }
}
