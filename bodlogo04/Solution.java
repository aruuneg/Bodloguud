package bodlogo04;

public class Solution {

    public static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        // 8 чиглэл бүрийн хамгийн их боломжит алхам
        int left = c_q - 1;
        int right = n - c_q;
        int up = n - r_q;
        int down = r_q - 1;
        int upLeft = Math.min(up, left);
        int upRight = Math.min(up, right);
        int downLeft = Math.min(down, left);
        int downRight = Math.min(down, right);

        for (int[] obs : obstacles) {
            int r_o = obs[0];
            int c_o = obs[1];

            if (r_o == r_q) {
                // same row
                if (c_o < c_q) left = Math.min(left, c_q - c_o - 1);
                else if (c_o > c_q) right = Math.min(right, c_o - c_q - 1);
            } else if (c_o == c_q) {
                // same column
                if (r_o < r_q) down = Math.min(down, r_q - r_o - 1);
                else if (r_o > r_q) up = Math.min(up, r_o - r_q - 1);
            } else if (Math.abs(r_o - r_q) == Math.abs(c_o - c_q)) {
                // diagonal
                if (r_o > r_q && c_o < c_q) upLeft = Math.min(upLeft, r_o - r_q - 1);
                else if (r_o > r_q && c_o > c_q) upRight = Math.min(upRight, r_o - r_q - 1);
                else if (r_o < r_q && c_o < c_q) downLeft = Math.min(downLeft, r_q - r_o - 1);
                else if (r_o < r_q && c_o > c_q) downRight = Math.min(downRight, r_q - r_o - 1);
            }
        }

        return left + right + up + down + upLeft + upRight + downLeft + downRight;
    }

    public static void main(String[] args) {
        int n = 5, k = 3, r_q = 4, c_q = 3;
        int[][] obstacles = {
            {5, 5},
            {4, 2},
            {2, 3}
        };
        System.out.println(queensAttack(n, k, r_q, c_q, obstacles)); // Output: 10
    }
}