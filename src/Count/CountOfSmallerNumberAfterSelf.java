package Count;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountOfSmallerNumberAfterSelf {
    static class Pair {
        int val, idx;
        Pair(int v, int i) { val = v; idx = i; }
    }

    static void mergeSort(Pair[] a, int l, int r, int[] ans) {
        if (l >= r) return;
        int m = (l + r) / 2;
        mergeSort(a, l, m, ans);
        mergeSort(a, m + 1, r, ans);

        List<Pair> tmp = new ArrayList<>();
        int i = l, j = m + 1, cnt = 0;

        while (i <= m && j <= r) {
            if (a[i].val <= a[j].val) {
                ans[a[i].idx] += cnt;
                tmp.add(a[i++]);
            } else {
                cnt++;
                tmp.add(a[j++]);
            }
        }
        while (i <= m) {
            ans[a[i].idx] += cnt;
            tmp.add(a[i++]);
        }
        while (j <= r) tmp.add(a[j++]);

        for (int k = l; k <= r; k++) a[k] = tmp.get(k - l);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] p = sc.nextLine().split(" ");
        int n = p.length;
        Pair[] a = new Pair[n];
        for (int i = 0; i < n; i++) a[i] = new Pair(Integer.parseInt(p[i]), i);
        int[] ans = new int[n];
        mergeSort(a, 0, n - 1, ans);
        for (int x : ans) System.out.print(x + " ");
    }
}
