package RMQ;

import java.util.Scanner;

public class RMQ {

    static int rangeMinQuery(int[] arr, int l, int r) {
        int min = Integer.MAX_VALUE;
        for (int i = l; i <= r; i++) {
            min = Math.min(min, arr[i]);
        }
        return min;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] parts = sc.nextLine().trim().split(" ");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }

        // Read query (l r)
        int l = sc.nextInt();
        int r = sc.nextInt();

        System.out.println(rangeMinQuery(arr, l, r));
    }
}
