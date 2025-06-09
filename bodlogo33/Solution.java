package bodlogo33;

import java.util.*;

public class Solution {
    static class Point {
        int x, y, dist;
        Point(int x, int y, int dist) {
            this.x = x; this.y = y; this.dist = dist;
        }
    }

    public static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startX, startY, 0));
        visited[startX][startY] = true;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            if (p.x == goalX && p.y == goalY) {
                return p.dist;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = p.x;
                int ny = p.y;

                
                while (true) {
                    nx += dx[dir];
                    ny += dy[dir];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n || grid[nx].charAt(ny) == 'X')
                        break;

                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new Point(nx, ny, p.dist + 1));
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            String[] grid = new String[n];
            for (int i = 0; i < n; i++) {
                grid[i] = sc.next();
            }
            int startX = sc.nextInt();
            int startY = sc.nextInt();
            int goalX = sc.nextInt();
            int goalY = sc.nextInt();

            System.out.println(minimumMoves(grid, startX, startY, goalX, goalY));
        }
    }
}
