package NQueen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    static List<List<String>> res = new ArrayList<>();
    static boolean[] col, d1, d2;

    static void backtrack(char[][] b, int r) {
        int n = b.length;
        if (r == n) {
            List<String> board = new ArrayList<>();
            for (char[] row : b) board.add(new String(row));
            res.add(board);
            return;
        }
        for (int c = 0; c < n; c++) {
            if (col[c] || d1[r - c + n] || d2[r + c]) continue;
            b[r][c] = 'Q';
            col[c] = d1[r - c + n] = d2[r + c] = true;
            backtrack(b, r + 1);
            b[r][c] = '.';
            col[c] = d1[r - c + n] = d2[r + c] = false;
        }
    }

    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[n][n];
        for (char[] r : board) Arrays.fill(r, '.');

        col = new boolean[n];
        d1 = new boolean[2 * n];
        d2 = new boolean[2 * n];

        backtrack(board, 0);
        System.out.println(res);
    }
}
