/**
 * Because we are using JS, we can "cheat" as JS map keeps track of insertion
 * order (ie: we can use it to keep track of the LRU item, aka the first item in
 * the map, bc items added to the map will be added to the "end").
 * 
 * The more expected answer involves using a doubly linked list to keep track
 * of the LRU item.
 */

/**
 * Class representing a Least Recently Used Cache.
 */
class LRUCache {
    /**
     * Create an LRUCache.
     * @description Default capacity is 1.
     * @param {number} capacity - Positive integer representing LRU capacity.
     */
    constructor(capacity) {
        if (!capacity || capacity < 0) {
            this.capacity = 1;
        } else if (typeof(capacity) === 'number') {
            this.capacity = capacity;
        }

        this.cache = new Map();
        this.head = new DLinkedNode(null, null, null);
        this.tail = new DLinkedNode(null, this.head, null);
        this.head.next = this.tail;
    }

    /**
     * Gets the value of the key if the key exists in the cache.
     * @param {number} key - Key of the value to get.
     * @returns {number} The value associated with the input key, or
     * -1 if not found.
     */
    get(key) {
        const node = this.cache.get(key);

        if (node === undefined) {
            return -1;
        }

        this.removeNode(node);
        this.addNode(node);

        return node.value;
    }

     /**
      * Set or insert the value if the key is not already present.
      * @description When the cache has reached its capacity, it should
      * invalidate the least recently used item before inserting a new item.
      * @param {number} key - Key to be inserted or set.
      * @param {number} value - Value to be set for given key.
      */
    put(key, value) {
        const node = this.cache.get(key);
        const newNode = new DLinkedNode(key, value);
        
        // If the key does not exist in the map, then add to lru linked list,
        // and the map (key = key, value = node).
        if (node === undefined) {
            this.addNode(newNode); // this will set newNode prev and next
            this.cache.set(key, newNode);

            // If over-capacity after adding, pop tail of linked list (lru),
            // and remove the associated key from the map.
            if (this.cache.size > this.capacity) {
                const evicted = this.popTail();
                this.cache.delete(evicted.key);
            }
        // If they key exists in the map, update the value, and move the node
        // to the front of the linked list (most recently used).
        } else {
            node.value = value;
            this.removeNode(node);
            this.addNode(node);
        }
    }

    /* Helper methods */
    /**
     * Adds a node after head.
     * @param {DLinkedNode} node 
     */
    addNode(node) {
        node.prev = this.head;
        node.next = this.head.next;
        this.head.next.prev = node;
        this.head.next = node;
    }

    /**
     * Removes a node.
     * @param {DLinkedNode} node 
     */
    removeNode(node) {
        const prevNode = node.prev;
        const nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    /**
     * Pops the tail off the linked list.
     * @returns The node which was removed.
     */
    popTail() {
        const toRemove = this.tail.prev;
        this.removeNode(toRemove);

        return toRemove;
    }
}

class DLinkedNode {
    constructor(key = null, value = null, prev = null, next = null) {
        this.key = key;
        this.value = value;
        this.prev = prev;
        this.next = next;
    }
}

(function runTests() {
    let cache = new LRUCache(2);

    cache.put(1, 1);
    cache.put(2, 2);
    console.log(cache.get(1) === 1); // returns 1

    cache.put(3, 3); // evicts key 2
    console.log(cache.get(2) === -1); // returns -1

    cache.put(4, 4); // evicts key 1
    console.log(cache.get(1) === -1); // returns -1
    console.log(cache.get(3) === 3); // returns 3
    console.log(cache.get(4) === 4); // returns 4
})();