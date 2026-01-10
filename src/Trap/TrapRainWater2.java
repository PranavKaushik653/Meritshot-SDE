package Trap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TrapRainWater2 {
    static class Cell {
        int r, c, h;
        Cell(int r, int c, int h) {
            this.r = r;
            this.c = c;
            this.h = h;
        }
    }

    static int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        if (m <= 2 || n <= 2) return 0;

        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> pq =
                new PriorityQueue<>(Comparator.comparingInt(a -> a.h));

        // 1️⃣ Add all boundary cells
        for (int i = 0; i < m; i++) {
            pq.add(new Cell(i, 0, heightMap[i][0]));
            pq.add(new Cell(i, n - 1, heightMap[i][n - 1]));
            visited[i][0] = visited[i][n - 1] = true;
        }

        for (int j = 1; j < n - 1; j++) {
            pq.add(new Cell(0, j, heightMap[0][j]));
            pq.add(new Cell(m - 1, j, heightMap[m - 1][j]));
            visited[0][j] = visited[m - 1][j] = true;
        }

        int water = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        // 2️⃣ Process heap
        while (!pq.isEmpty()) {
            Cell cur = pq.poll();

            for (int[] d : dirs) {
                int nr = cur.r + d[0];
                int nc = cur.c + d[1];

                if (nr < 0 || nc < 0 || nr >= m || nc >= n || visited[nr][nc])
                    continue;

                visited[nr][nc] = true;

                int nh = heightMap[nr][nc];
                if (nh < cur.h) {
                    water += cur.h - nh;
                }

                pq.add(new Cell(nr, nc, Math.max(cur.h, nh)));
            }
        }
        return water;
    }

    public static void main(String[] args) {
        int[][] heightMap = {
                {1,4,3,1,3,2},
                {3,2,1,3,2,4},
                {2,3,3,2,3,1}
        };
        System.out.println(trapRainWater(heightMap));
    }
}
