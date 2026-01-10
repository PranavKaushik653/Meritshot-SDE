package XOR;

import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class XORSubArr {
    static int maxXORSubarray(int[] arr) {
        int max = 0, mask = 0;
        int prefixXor = 0;
        Set<Integer> set = new HashSet<>();
        set.add(0);

        for (int i = 31; i >= 0; i--) {
            mask |= (1 << i);
            Set<Integer> temp = new HashSet<>();
            prefixXor = 0;
            temp.add(0);

            for (int n : arr) {
                prefixXor ^= n;
                temp.add(prefixXor & mask);
            }

            int candidate = max | (1 << i);
            for (int p : temp) {
                if (temp.contains(p ^ candidate)) {
                    max = candidate;
                    break;
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] p = sc.nextLine().split(" ");
        int[] arr = new int[p.length];
        for (int i = 0; i < p.length; i++)
            arr[i] = Integer.parseInt(p[i]);

        System.out.println(maxXORSubarray(arr));
    }
}
