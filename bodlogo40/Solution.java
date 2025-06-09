package bodlogo40;

import java.util.Scanner;

public class Solution {
    static int N;
    static long[][][] fenw;

    static void update(int x, int y, int z, long val) {
        for (int i = x; i <= N; i += i & (-i)) {
            for (int j = y; j <= N; j += j & (-j)) {
                for (int k = z; k <= N; k += k & (-k)) {
                    fenw[i][j][k] += val;
                }
            }
        }
    }

    static long query(int x, int y, int z) {
        long sum = 0;
        for (int i = x; i > 0; i -= i & (-i)) {
            for (int j = y; j > 0; j -= j & (-j)) {
                for (int k = z; k > 0; k -= k & (-k)) {
                    sum += fenw[i][j][k];
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            N = sc.nextInt();
            int Q = sc.nextInt();
            fenw = new long[N + 1][N + 1][N + 1];

            while (Q-- > 0) {
                String cmd = sc.next();
                if (cmd.equals("UPDATE")) {
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    int z = sc.nextInt();
                    long W = sc.nextLong();

                    // Одоогийн утгыг олохын тулд QUERY ашиглана
                    long current = query(x, y, z) - query(x - 1, y, z) - query(x, y - 1, z) - query(x, y, z - 1)
                            + query(x - 1, y - 1, z) + query(x - 1, y, z - 1) + query(x, y - 1, z - 1)
                            - query(x - 1, y - 1, z - 1);

                    long diff = W - current;
                    update(x, y, z, diff);
                } else if (cmd.equals("QUERY")) {
                    int x1 = sc.nextInt();
                    int y1 = sc.nextInt();
                    int z1 = sc.nextInt();
                    int x2 = sc.nextInt();
                    int y2 = sc.nextInt();
                    int z2 = sc.nextInt();

                    long res = query(x2, y2, z2) - query(x1 - 1, y2, z2) - query(x2, y1 - 1, z2) - query(x2, y2, z1 - 1)
                            + query(x1 - 1, y1 - 1, z2) + query(x1 - 1, y2, z1 - 1) + query(x2, y1 - 1, z1 - 1)
                            - query(x1 - 1, y1 - 1, z1 - 1);

                    System.out.println(res);
                }
            }
        }
        sc.close();
    }
}