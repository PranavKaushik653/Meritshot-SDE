package DistinctSubstring;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CountDistinctSubstring {
    static int countDistinctSubstrings(String s) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                sb.append(s.charAt(j));
                set.add(sb.toString());
            }
        }
        return set.size()+1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(countDistinctSubstrings(s));
    }
}
