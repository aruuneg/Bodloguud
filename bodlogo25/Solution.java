package bodlogo25;

import java.io.*;
import java.util.*;

public class Solution {

    public static int twoStacks(int x, List<Integer> a, List<Integer> b) {
       
        int m = b.size();
        int sumB = 0;
        int j = 0;
        while (j < m && sumB + b.get(j) <= x) {
            sumB += b.get(j);
            j++;
        }

        int maxCount = j;
        int sum = sumB;

        for (int i = 1; i <= a.size(); i++) {
            sum += a.get(i - 1);

            while (sum > x && j > 0) {
                j--;
                sum -= b.get(j);
            }

            if (sum > x) break;

            maxCount = Math.max(maxCount, i + j);
        }

        return maxCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int g = Integer.parseInt(br.readLine().trim());

        for (int gi = 0; gi < g; gi++) {
            String[] parts = br.readLine().trim().split(" ");
            int x = Integer.parseInt(parts[2]);

            List<Integer> a = new ArrayList<>();
            for (String s : br.readLine().trim().split(" ")) {
                a.add(Integer.parseInt(s));
            }

            List<Integer> b = new ArrayList<>();
            for (String s : br.readLine().trim().split(" ")) {
                b.add(Integer.parseInt(s));
            }

            System.out.println(twoStacks(x, a, b));
        }

        br.close();
    }
}
