import java.util.HashMap;
import java.util.Map;

public class LRUCache_DLL {
    private int capacity;
    private Map<Integer, Node> cache;
    private Node dummyHead;
    private Node dummyTail;

    public LRUCache_DLL(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.dummyHead = new Node(0, 0);
        this.dummyTail = new Node(0, 0);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public int get(int key) {
        var node = cache.get(key);
        if (node == null)
            return -1;
        // break the current chain and link it by removing the node under question
        node.prev.next = node.next;
        node.next.prev = node.prev;

        // define the new head
        var oldHead = dummyHead.next;
        dummyHead.next = node;
        node.prev = dummyHead;
        node.next = oldHead;
        oldHead.prev = node;

        return node.value;
    }

    public void put(int key, int value) {
        var existingNode = cache.get(key);
        if (existingNode != null) {
            existingNode.value = value;
            var oldHead = dummyHead.next;
            dummyHead.next = existingNode;
            existingNode.prev.next = existingNode.next;
            existingNode.next.prev = existingNode.prev;
            existingNode.next = oldHead;
            existingNode.prev = dummyHead;
            oldHead.prev = existingNode;
        } else {
            if (cache.size() >= capacity) {
                // remove least recently used key from cache
                var lruNode = dummyTail.prev; // real LRU node
                cache.remove(lruNode.key);
                dummyTail.prev = lruNode.prev;
                lruNode.prev.next = dummyTail;
            }
            var newNode = new Node(key, value);
            cache.put(key, newNode);
            var oldHead = dummyHead.next;
            dummyHead.next = newNode;
            newNode.next = oldHead;
            newNode.prev = dummyHead;
            oldHead.prev = newNode;
        }

    }

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
