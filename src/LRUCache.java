import java.time.LocalDateTime;

public class LRUCache {
    private final Node[] nodes;
    private int size;

    public LRUCache(int capacity) {
        this.nodes = new Node[capacity];
    }

    public String get(int key) {
        for (var node : nodes) {
            if (node.getKey() == key) {
                node.setAccessedAt(LocalDateTime.now());
                return node.getValue();
            }
        }
        return "-1";
    }

    public void put(int key, String value) {
        if (size < nodes.length) {
            nodes[size - 1] = new Node(key, value);
        }

        var leastRecentlyUsedNodeIndex = 0;
        var leastRecentTime = LocalDateTime.now();
        for (var i = 0; i < nodes.length; i++) {
            if (nodes[i].getAccessedAt().isBefore(leastRecentTime)) {
                leastRecentTime = nodes[i].getAccessedAt();
                leastRecentlyUsedNodeIndex = i;
            }
            if (nodes[i].getKey() == key) {
                nodes[i].setValue(value);
                return;
            }
        }
        nodes[leastRecentlyUsedNodeIndex] = new Node(key, value);
        size++;
    }

    static class Node {
        int key;
        String value;
        LocalDateTime accessedAt;

        Node(int key, String value) {
            this.key = key;
            this.value = value;
        }

        int getKey() {
            return key;
        }

        String getValue() {
            return value;
        }

        void setValue(String value) {
            this.value = value;
        }

        void setAccessedAt(LocalDateTime accessedAt) {
            this.accessedAt = accessedAt;
        }

        LocalDateTime getAccessedAt() {
            return accessedAt;
        }
    }
}
