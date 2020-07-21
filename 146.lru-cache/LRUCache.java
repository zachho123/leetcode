import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

class LRUCache {

    private int capacity;
    private Map<Integer, Integer> map;
    private LinkedList<Integer> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.cache = new LinkedList<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            if (!(cache.getFirst() == key)) {
                cache.remove((Integer)key);
                cache.addFirst(key);
            }
            return map.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            cache.remove((Integer)key);
        } else {
            if (cache.size() == capacity) {
                map.remove(cache.getLast());
                cache.removeLast();
            }
        }

        map.put(key, value);
        cache.addFirst(key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
