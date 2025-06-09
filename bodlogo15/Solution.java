package bodlogo15;

import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'sherlockAndMinimax' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER p
     *  3. INTEGER q
     */

    public static int sherlockAndMinimax(List<Integer> arr, int p, int q) {
        // Sort the array to easily find gaps
        Collections.sort(arr);

        // List to hold candidate points to check
        List<Integer> candidates = new ArrayList<>();

        // Add boundaries p and q
        candidates.add(p);
        candidates.add(q);

        // Add midpoints between consecutive elements in arr (if within [p,q])
        for (int i = 0; i < arr.size() - 1; i++) {
            int mid = (arr.get(i) + arr.get(i + 1)) / 2;
            if (mid >= p && mid <= q) {
                candidates.add(mid);
            }
            // If the sum is odd, also consider mid+1 to check both sides of midpoint
            if ((arr.get(i) + arr.get(i + 1)) % 2 != 0) {
                int midPlusOne = mid + 1;
                if (midPlusOne >= p && midPlusOne <= q) {
                    candidates.add(midPlusOne);
                }
            }
        }

        int bestCandidate = p;
        int maxMinDist = -1;

        // For each candidate, find the minimum distance to any element in arr
        for (int candidate : candidates) {
            int minDist = Integer.MAX_VALUE;

            // Binary search to find closest element in arr
            int idx = Collections.binarySearch(arr, candidate);
            if (idx < 0) {
                idx = -(idx + 1);
            }
            // Check distance to element at idx (if exists)
            if (idx < arr.size()) {
                minDist = Math.min(minDist, Math.abs(arr.get(idx) - candidate));
            }
            // Check distance to element before idx (if exists)
            if (idx > 0) {
                minDist = Math.min(minDist, Math.abs(arr.get(idx - 1) - candidate));
            }

            // Update best candidate if minDist is better or equal but candidate smaller
            if (minDist > maxMinDist || (minDist == maxMinDist && candidate < bestCandidate)) {
                maxMinDist = minDist;
                bestCandidate = candidate;
            }
        }

        return bestCandidate;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int p = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        int result = Result.sherlockAndMinimax(arr, p, q);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
