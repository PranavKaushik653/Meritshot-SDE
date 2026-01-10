package KMP;

import java.util.Scanner;

public class KMPAlgo {
    static int[] buildLPS(String p) {
        int[] lps = new int[p.length()];
        int len = 0, i = 1;

        while (i < p.length()) {
            if (p.charAt(i) == p.charAt(len)) {
                lps[i++] = ++len;
            } else if (len != 0) {
                len = lps[len - 1];
            } else {
                lps[i++] = 0;
            }
        }
        return lps;
    }

    static int search(String text, String pat) {
        int[] lps = buildLPS(pat);
        int i = 0, j = 0;

        while (i < text.length()) {
            if (text.charAt(i) == pat.charAt(j)) {
                i++; j++;
            }
            if (j == pat.length()) {
                return i - j;   // match found
            } else if (i < text.length() && text.charAt(i) != pat.charAt(j)) {
                if (j != 0) j = lps[j - 1];
                else i++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String pat = sc.nextLine();
        System.out.println(search(text, pat));
    }
}
