package Frog;

import java.util.*;

public class FrogJump {
    static boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> dp = new HashMap<>();
        for (int s : stones) dp.put(s, new HashSet<>());
        dp.get(0).add(0);

        for (int s : stones) {
            for (int k : dp.get(s)) {
                for (int step = k - 1; step <= k + 1; step++) {
                    if (step > 0 && dp.containsKey(s + step)) {
                        dp.get(s + step).add(step);
                    }
                }
            }
        }
        return !dp.get(stones[stones.length - 1]).isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] p = sc.nextLine().split(" ");
        int[] stones = new int[p.length];
        for (int i = 0; i < p.length; i++) stones[i] = Integer.parseInt(p[i]);
        System.out.println(canCross(stones));
    }
}
