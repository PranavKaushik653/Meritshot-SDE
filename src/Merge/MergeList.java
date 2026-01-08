package Merge;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MergeList {

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){this.val=val;}
    }
    static ListNode mergeList(ListNode[] lists){
        PriorityQueue<ListNode> pq=new PriorityQueue<>(Comparator.comparingInt(a->a.val));

        for(ListNode node : lists){
            if(node!=null)pq.offer(node);
        }
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;

        while (!pq.isEmpty()){
            ListNode min=pq.poll();
            tail.next=min;
            tail=tail.next;

            if(min.next != null){
                pq.offer(min.next);
            }
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = Integer.parseInt(sc.nextLine().trim());
        ListNode[] lists = new ListNode[k];

        for (int i = 0; i < k; i++) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                lists[i] = null;
                continue;
            }

            String[] parts = line.split(" ");
            ListNode dummy = new ListNode(0);
            ListNode curr = dummy;

            for (String p : parts) {
                curr.next = new ListNode(Integer.parseInt(p));
                curr = curr.next;
            }
            lists[i] = dummy.next;
        }

        ListNode res = mergeList(lists);

        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
