package MinWinSub;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MinimumWindowSubstring {
    static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray())
            need.put(c, need.getOrDefault(c, 0) + 1);

        int left = 0, count = 0, minLen = Integer.MAX_VALUE, start = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (need.containsKey(c)) {
                need.put(c, need.get(c) - 1);
                if (need.get(c) >= 0) count++;
            }

            while (count == t.length()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                char l = s.charAt(left++);
                if (need.containsKey(l)) {
                    need.put(l, need.get(l) + 1);
                    if (need.get(l) > 0) count--;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println(minWindow(s, t));
    }
}
