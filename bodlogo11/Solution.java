package bodlogo11;

import java.io.*;
import java.util.*;

class Result {

    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        int m = matrix.size();
        int n = matrix.get(0).size();
        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {
            List<Integer> elements = new ArrayList<>();

            // Top row
            for (int i = layer; i < n - layer; i++) {
                elements.add(matrix.get(layer).get(i));
            }
            // Right column
            for (int i = layer + 1; i < m - 1 - layer; i++) {
                elements.add(matrix.get(i).get(n - 1 - layer));
            }
            // Bottom row
            for (int i = n - 1 - layer; i >= layer; i--) {
                elements.add(matrix.get(m - 1 - layer).get(i));
            }
            // Left column
            for (int i = m - 2 - layer; i > layer; i--) {
                elements.add(matrix.get(i).get(layer));
            }

            int len = elements.size();
            int rot = r % len;

            List<Integer> rotated = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                rotated.add(elements.get((i + rot) % len));
            }

            int index = 0;
            // Top row
            for (int i = layer; i < n - layer; i++) {
                matrix.get(layer).set(i, rotated.get(index++));
            }
            // Right column
            for (int i = layer + 1; i < m - 1 - layer; i++) {
                matrix.get(i).set(n - 1 - layer, rotated.get(index++));
            }
            // Bottom row
            for (int i = n - 1 - layer; i >= layer; i--) {
                matrix.get(m - 1 - layer).set(i, rotated.get(index++));
            }
            // Left column
            for (int i = m - 2 - layer; i > layer; i--) {
                matrix.get(i).set(layer, rotated.get(index++));
            }
        }

        // Print rotated matrix
        for (List<Integer> row : matrix) {
            for (Integer val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        int r = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] matrixRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> matrixRowItems = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int matrixItem = Integer.parseInt(matrixRowTempItems[j]);
                matrixRowItems.add(matrixItem);
            }

            matrix.add(matrixRowItems);
        }

        Result.matrixRotation(matrix, r);

        bufferedReader.close();
    }
}