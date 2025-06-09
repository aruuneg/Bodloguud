package bodlogo8;

import java.io.*;
import java.util.*;

class Result {

    public static String gridSearch(List<String> G, List<String> P) {
        int R = G.size();
        int C = G.get(0).length();
        int r = P.size();
        int c = P.get(0).length();

        for (int i = 0; i <= R - r; i++) {
            for (int j = 0; j <= C - c; j++) {
                if (G.get(i).substring(j, j + c).equals(P.get(0))) {
                    boolean match = true;
                    for (int k = 1; k < r; k++) {
                        if (!G.get(i + k).substring(j, j + c).equals(P.get(k))) {
                            match = false;
                            break;
                        }
                    }
                    if (match) {
                        return "YES";
                    }
                }
            }
        }
        return "NO";
    }
}

public class bodlogo8 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // Output to console for VSCode (no OUTPUT_PATH env)
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int R = Integer.parseInt(firstMultipleInput[0]);

            List<String> G = new ArrayList<>();

            for (int i = 0; i < R; i++) {
                String GItem = bufferedReader.readLine();
                G.add(GItem);
            }

            String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int r = Integer.parseInt(secondMultipleInput[0]);

            List<String> P = new ArrayList<>();

            for (int i = 0; i < r; i++) {
                String PItem = bufferedReader.readLine();
                P.add(PItem);
            }

            String result = Result.gridSearch(G, P);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
