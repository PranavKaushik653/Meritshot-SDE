package XOR;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class XORNum {
    static int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;

        for (int i = 31; i >= 0; i--) {
            mask |= (1 << i);
            Set<Integer> set = new HashSet<>();

            for (int n : nums)
                set.add(n & mask);

            int candidate = max | (1 << i);
            for (int p : set) {
                if (set.contains(p ^ candidate)) {
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
        int[] nums = new int[p.length];
        for (int i = 0; i < p.length; i++)
            nums[i] = Integer.parseInt(p[i]);

        System.out.println(findMaximumXOR(nums));
    }
}
