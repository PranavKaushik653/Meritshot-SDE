package LLCycle;

import java.util.Scanner;

public class CycleDetect {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
    static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Step 1: detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Step 2: find start of cycle
                ListNode entry = head;
                while (entry != slow) {
                    entry = entry.next;
                    slow = slow.next;
                }
                return entry;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        String[] vals = sc.nextLine().trim().split(" ");
        ListNode temp=new ListNode(0);
        ListNode current=temp;

        ListNode [] nodes=new ListNode[vals.length];

        for(int i=0;i< vals.length;i++){
            nodes[i] = new ListNode(Integer.parseInt(vals[i]));
            current.next = nodes[i];
            current = current.next;
        }
        String posLine = sc.nextLine().trim();
        int pos = Integer.parseInt(posLine.split("=")[1]);

        if (pos != -1) {
            current.next = nodes[pos];
        }

        ListNode cycleStart = detectCycle(temp.next);

        if (cycleStart != null) {
            System.out.println(cycleStart.val);
        } else {
            System.out.println("null");
        }
    }
}

