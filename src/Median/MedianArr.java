package Median;

import java.util.Arrays;
import java.util.Scanner;

public class MedianArr {
    static double findMedian(int[] A, int[] B) {
        if (A.length > B.length) return findMedian(B, A);

        int n = A.length, m = B.length;
        int low = 0, high = n;

        while (low <= high) {
            int cutA = (low + high) / 2;
            int cutB = (n + m + 1) / 2 - cutA;

            int leftA = (cutA == 0) ? Integer.MIN_VALUE : A[cutA - 1];
            int leftB = (cutB == 0) ? Integer.MIN_VALUE : B[cutB - 1];
            int rightA = (cutA == n) ? Integer.MAX_VALUE : A[cutA];
            int rightB = (cutB == m) ? Integer.MAX_VALUE : B[cutB];

            if (leftA <= rightB && leftB <= rightA) {
                if ((n + m) % 2 == 0)
                    return (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2.0;
                else
                    return Math.max(leftA, leftB);
            } else if (leftA > rightB) {
                high = cutA - 1;
            } else {
                low = cutA + 1;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] p1 = sc.nextLine().split(" ");
        String[] p2 = sc.nextLine().split(" ");

        int[] A = Arrays.stream(p1).mapToInt(Integer::parseInt).toArray();
        int[] B = Arrays.stream(p2).mapToInt(Integer::parseInt).toArray();

        System.out.println(findMedian(A, B));
    }
}
