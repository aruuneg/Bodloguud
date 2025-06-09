package bodlogo26;

import java.io.*;
import java.util.*;

public class Solution {

    public static long largestRectangle(List<Integer> h) {
        int n = h.size();
        Stack<Integer> stack = new Stack<>();
        long maxArea = 0;

        for (int i = 0; i <= n; i++) {
            long currHeight = (i == n) ? 0 : h.get(i);
            while (!stack.isEmpty() && currHeight < h.get(stack.peek())) {
                long height = h.get(stack.pop());
                int leftIndex = stack.isEmpty() ? -1 : stack.peek();
                long width = i - leftIndex - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer.parseInt(br.readLine().trim());

        String[] parts = br.readLine().trim().split(" ");
        List<Integer> heights = new ArrayList<>();
        for (String p : parts) heights.add(Integer.parseInt(p));

        System.out.println(largestRectangle(heights));
    }
}
