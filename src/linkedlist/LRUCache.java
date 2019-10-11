package linkedlist;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    static class Node {
        int key;
        int value;
        Node next;
        Node previous;
        Node(int key){
            this.key = key;
        }
    }

    Map<Integer, Node> cache;
    int capacity;

    Node head = new Node(-1);
    Node tail = new Node(-1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        head.next = tail;
        tail.previous = head;
    }

    public int get(int key) {
        if(!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        node.previous.next = node.next;
        node.next.previous = node.previous;
        moveToFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.getOrDefault(key, new Node(key));
        node.value = value;
        if(capacity == 0){
            cache.remove(tail.previous.key);
            tail = tail.previous;
            capacity++;
        }
        if(cache.containsKey(key)){
            node.previous.next = node.next;
            node.next.previous = node.previous;
        }
        moveToFront(node);
        cache.put(key, node);

        capacity--;

    }
    private void moveToFront(Node node) {
        head.next.previous = node;
        node.next = head.next;
        node.previous = head;
        head.next = node;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4

    }
}

/**
 * Your linkedlist.LRUCache object will be instantiated and called as such:
 * linkedlist.LRUCache obj = new linkedlist.LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */