import java.util.HashMap;
// import java.util.LinkedList;

public class LRUCache {
    private HashMap<Integer, Node> cache;
    // private LinkedList<Node> lru;
    private int capacity;
    private Node head;
    private Node tail;
    
    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        // this.lru = new LinkedList<>();
        this.capacity = capacity;
        this.head = new Node();
        this.tail = new Node();
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        if (this.cache.containsKey(key)) {
            Node node = cache.get(key);
            // this.lru.remove(node);
            // this.lru.addFirst(node);
            this.remove(node);
            this.addFirst(node);
            return node.getValue();
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (this.cache.containsKey(key)) {
            Node node = this.cache.get(key);
            node.setValue(value);
            // this.lru.remove(node);
            // this.lru.addFirst(node);
            this.remove(node);
            this.addFirst(node);
        } else {
            Node newNode = new Node(key, value);

            if (this.cache.size() + 1 > this.capacity) {
                Node toEvict = this.removeLast();
                this.cache.remove(toEvict.getKey());
            }

            // this.lru.addFirst(newNode);
            this.addFirst(newNode);
            this.cache.put(key, newNode);
        }
    }

    private void addFirst(Node newNode) {
        newNode.next = this.head.next;
        newNode.prev = this.head;
        this.head.next.prev = newNode;
        this.head.next = newNode;
    }

    private void remove(Node toRemove) {
        toRemove.prev.next = toRemove.next;
        toRemove.next.prev = toRemove.prev;
    }

    private Node removeLast() {
        Node removed = this.tail.prev;
        this.remove(removed);
        return removed;
    } 

    public class Node {
        private int key;
        private int value;
        public Node prev;
        public Node next;

        public Node() {}
    
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    
        public int getKey() {
            return this.key;
        }
    
        public int getValue() {
            return this.value;
        }
    
        public void setValue(int value) {
            this.value = value;
        }
    }
}