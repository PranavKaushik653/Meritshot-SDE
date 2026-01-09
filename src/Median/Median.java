package Median;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Median {
    static class MedianFinder {

        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();

        void addNum(int num) {
            if (left.isEmpty() || num <= left.peek()) {
                left.offer(num);
            } else {
                right.offer(num);
            }
            if (left.size() > right.size() + 1) {
                right.offer(left.poll());
            } else if (right.size() > left.size()) {
                left.offer(right.poll());
            }
        }

        double findMedian() {
            if (left.size() == right.size()) {
                return (left.peek() + right.peek()) / 2.0;
            }
            return left.peek();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MedianFinder mf = new MedianFinder();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) break;

            if (line.startsWith("addNum")) {
                int val = Integer.parseInt(
                        line.substring(line.indexOf('(') + 1, line.indexOf(')'))
                );
                mf.addNum(val);
            } else if (line.equals("findMedian()")) {
                System.out.println(mf.findMedian());
            }
        }
    }
}
