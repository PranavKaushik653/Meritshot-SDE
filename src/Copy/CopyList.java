package Copy;

import java.util.HashMap;
import java.util.Map;

public class CopyList {
    static class Node {
        int val;
        Node next, random;
        Node(int v) { val = v; }
    }

    static Node copyRandomList(Node head) {
        if (head == null) return null;

        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            Node copy = map.get(cur);
            copy.next = map.get(cur.next);
            copy.random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }
    static Node buildList(int[][] arr) {
        int n = arr.length;
        Node[] nodes = new Node[n];

        for (int i = 0; i < n; i++)
            nodes[i] = new Node(arr[i][0]);

        for (int i = 0; i < n - 1; i++)
            nodes[i].next = nodes[i + 1];

        for (int i = 0; i < n; i++) {
            if (arr[i][1] != -1)
                nodes[i].random = nodes[arr[i][1]];
        }
        return nodes[0];
    }
    static void printList(Node head, Map<Node, Integer> indexMap) {
        Node cur = head;
        System.out.print("[");
        while (cur != null) {
            System.out.print("[" + cur.val + ",");
            if (cur.random == null)
                System.out.print("null");
            else
                System.out.print(indexMap.get(cur.random));
            System.out.print("]");
            cur = cur.next;
            if (cur != null) System.out.print(",");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {

        int[][] input = {
                {7, -1},
                {13, 0},
                {11, 4},
                {10, 2},
                {1, 0}
        };

        Node head = buildList(input);

        Map<Node, Integer> indexMap = new HashMap<>();
        Node cur = head;
        int idx = 0;
        while (cur != null) {
            indexMap.put(cur, idx++);
            cur = cur.next;
        }
        Node copied = copyRandomList(head);
        printList(copied, indexMap);
    }
}
