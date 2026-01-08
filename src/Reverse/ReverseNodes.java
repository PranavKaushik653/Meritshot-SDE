package Reverse;

import java.util.Scanner;

public class ReverseNodes {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
        static ListNode reverseKGroup(ListNode head, int k) {
            ListNode curr = head;
            int count = 0;

            while (curr != null && count < k) {
                curr = curr.next;
                count++;
            }
            if (count < k) return head;

            // reverse k nodes
            curr = head;
            ListNode prev = null, next = null;
            count = 0;

            while (curr != null && count < k) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }

            head.next = reverseKGroup(curr, k);
            return prev;
        }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] parts = sc.nextLine().trim().split(" ");
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (String p : parts) {
            tail.next = new ListNode(Integer.parseInt(p));
            tail = tail.next;
        }

        String kLine = sc.nextLine().trim();
        int k = kLine.contains("=")
                ? Integer.parseInt(kLine.split("=")[1])
                : Integer.parseInt(kLine);

        ListNode res = reverseKGroup(dummy.next, k);

        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}

