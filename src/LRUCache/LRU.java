package LRUCache;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LRU {
    static class Node {
        int key, val;
        Node prev, next;
        Node(int k, int v) { key = k; val = v; }
    }

    static class LRUCache {
        int cap;
        Map<Integer, Node> map = new HashMap<>();
        Node head = new Node(0, 0), tail = new Node(0, 0);

        LRUCache(int capacity) {
            cap = capacity;
            head.next = tail;
            tail.prev = head;
        }

        void remove(Node n) {
            n.prev.next = n.next;
            n.next.prev = n.prev;
        }

        void add(Node n) {
            n.next = head.next;
            head.next.prev = n;
            head.next = n;
            n.prev = head;
        }

        int get(int key) {
            if (!map.containsKey(key)) return -1;
            Node n = map.get(key);
            remove(n);
            add(n);
            return n.val;
        }

        void put(int key, int value) {
            if (map.containsKey(key)) {
                remove(map.get(key));
            }
            if (map.size() == cap) {
                Node lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
            }
            Node n = new Node(key, value);
            add(n);
            map.put(key, n);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cap = Integer.parseInt(sc.nextLine());
        LRUCache cache = new LRUCache(cap);

        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if (s.startsWith("put")) {
                String[] p = s.substring(4, s.length() - 1).split(",");
                cache.put(Integer.parseInt(p[0]), Integer.parseInt(p[1]));
            } else if (s.startsWith("get")) {
                int k = Integer.parseInt(s.substring(4, s.length() - 1));
                System.out.println(cache.get(k));
            }
        }
    }
}
