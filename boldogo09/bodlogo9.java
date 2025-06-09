package bodlogo9;

import java.io.*;
import java.util.*;

class Result {


    public static int surfaceArea(List<List<Integer>> A) {
        int H = A.size();
        int W = A.get(0).size();

        int surface = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                int height = A.get(i).get(j);

                if (height > 0) {
                    // Дээш + доош талбай нэмэх
                    surface += 2;

                    // Зүүн талын зургийн өндрийн зөрүү
                    int left = (j > 0) ? A.get(i).get(j - 1) : 0;
                    surface += Math.max(height - left, 0);

                    // Баруун талын зургийн өндрийн зөрүү
                    int right = (j < W - 1) ? A.get(i).get(j + 1) : 0;
                    surface += Math.max(height - right, 0);

                    // Дээд талын зургийн өндрийн зөрүү
                    int up = (i > 0) ? A.get(i - 1).get(j) : 0;
                    surface += Math.max(height - up, 0);

                    // Доод талын зургийн өндрийн зөрүү
                    int down = (i < H - 1) ? A.get(i + 1).get(j) : 0;
                    surface += Math.max(height - down, 0);
                }
            }
        }

        return surface;
    }
}

public class bodlogo9 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // VSCode-д гаргалтыг консол дээр үзүүлэхээр өөрчиллөө
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int H = Integer.parseInt(firstMultipleInput[0]);
        int W = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> A = new ArrayList<>();

        for (int i = 0; i < H; i++) {
            String[] ARowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> ARowItems = new ArrayList<>();

            for (int j = 0; j < W; j++) {
                int AItem = Integer.parseInt(ARowTempItems[j]);
                ARowItems.add(AItem);
            }

            A.add(ARowItems);
        }

        int result = Result.surfaceArea(A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
