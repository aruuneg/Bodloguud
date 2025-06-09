package bodlogo12;

import java.io.*;
import java.util.*;

class Result {

    public static long maximumSum(List<Long> a, long m) {
        TreeSet<Long> prefixSet = new TreeSet<>();
        long max = 0;
        long prefix = 0;

        for (long num : a) {
            prefix = (prefix + num % m) % m;
            max = Math.max(max, prefix);

            // Find least prefix in set > prefix
            SortedSet<Long> tailSet = prefixSet.tailSet(prefix + 1);
            if (!tailSet.isEmpty()) {
                max = Math.max(max, (prefix - tailSet.first() + m) % m);
            }

            prefixSet.add(prefix);
        }

        return max;
    }
}


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int n = Integer.parseInt(firstMultipleInput[0]);

            long m = Long.parseLong(firstMultipleInput[1]);

            String[] aTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Long> a = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                long aItem = Long.parseLong(aTemp[i]);
                a.add(aItem);
            }

            long result = Result.maximumSum(a, m);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}