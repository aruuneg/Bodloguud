package bodlogo03;

import java.util.List;
import java.util.Arrays;

public class Solution {

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        int[] remainderCount = new int[k];
        for (int num : s) {
            remainderCount[num % k]++;
        }

        int result = 0;
        result += Math.min(remainderCount[0], 1); // only one element divisible by k

        for (int i = 1; i <= k / 2; i++) {
            if (i == k - i) {
                result += 1; // for the case when k is even and remainder is exactly k/2
            } else {
                result += Math.max(remainderCount[i], remainderCount[k - i]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> s = Arrays.asList(1, 7, 2, 4);
        int k = 3;
        System.out.println(nonDivisibleSubset(k, s)); // Output: 3
    }
}