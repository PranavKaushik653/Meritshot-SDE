package ZAlgo;

import java.util.Scanner;

public class ZAlgo {
    static int[] buildZ(String s) {
        int n = s.length();
        int[] z = new int[n];
        int l = 0, r = 0;

        for (int i = 1; i < n; i++) {
            if (i <= r)
                z[i] = Math.min(r - i + 1, z[i - l]);
            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i]))
                z[i]++;
            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }
        return z;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String pat = sc.nextLine();

        String combined = pat + "$" + text;
        int[] z = buildZ(combined);

        for (int i = 0; i < z.length; i++) {
            if (z[i] == pat.length())
                System.out.print(i - pat.length() - 1 + " ");
        }
    }
}
