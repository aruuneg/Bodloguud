package bodlogo13;

import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'boardCutting' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY cost_y
     *  2. INTEGER_ARRAY cost_x
     */

    public static int boardCutting(List<Integer> cost_y, List<Integer> cost_x) {
        // Зорилго: Зүсэлтүүдийг хамгийн өндөр үнэтэйгээс нь эхэлж хийнэ
        // Шаардлагатай хувьсагчдыг бэлдэх
        Collections.sort(cost_y, Collections.reverseOrder());
        Collections.sort(cost_x, Collections.reverseOrder());

        long totalCost = 0;
        int yPieces = 1; // босоо чиглэлд тасалсан хэсгүүдийн тоо
        int xPieces = 1; // хэвтээ чиглэлд тасалсан хэсгүүдийн тоо

        int i = 0, j = 0;
        int MOD = 1000000007;

        // Үнийн массивуудаас хамгийн их үнэтэй таслалыг сонгон авч аль чиглэлд хийхийг шийднэ
        while (i < cost_y.size() && j < cost_x.size()) {
            if (cost_y.get(i) > cost_x.get(j)) {
                totalCost += (long) cost_y.get(i) * xPieces;
                totalCost %= MOD;
                yPieces++;
                i++;
            } else {
                totalCost += (long) cost_x.get(j) * yPieces;
                totalCost %= MOD;
                xPieces++;
                j++;
            }
        }

        // Үлдсэн таслалыг хийх
        while (i < cost_y.size()) {
            totalCost += (long) cost_y.get(i) * xPieces;
            totalCost %= MOD;
            i++;
            yPieces++;
        }

        while (j < cost_x.size()) {
            totalCost += (long) cost_x.get(j) * yPieces;
            totalCost %= MOD;
            j++;
            xPieces++;
        }

        return (int)(totalCost % MOD);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int m = Integer.parseInt(firstMultipleInput[0]);

            int n = Integer.parseInt(firstMultipleInput[1]);

            String[] cost_yTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> cost_y = new ArrayList<>();

            for (int i = 0; i < m - 1; i++) {
                int cost_yItem = Integer.parseInt(cost_yTemp[i]);
                cost_y.add(cost_yItem);
            }

            String[] cost_xTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> cost_x = new ArrayList<>();

            for (int i = 0; i < n - 1; i++) {
                int cost_xItem = Integer.parseInt(cost_xTemp[i]);
                cost_x.add(cost_xItem);
            }

            int result = Result.boardCutting(cost_y, cost_x);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
