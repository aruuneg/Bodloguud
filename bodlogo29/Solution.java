package bodlogo29;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String str = bufferedReader.readLine();
            frequencyMap.put(str, frequencyMap.getOrDefault(str, 0) + 1);
        }

        int q = Integer.parseInt(bufferedReader.readLine().trim());
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < q; i++) {
            String query = bufferedReader.readLine();
            output.append(frequencyMap.getOrDefault(query, 0)).append("\n");
        }

        System.out.print(output);
        bufferedReader.close();
    }
}
