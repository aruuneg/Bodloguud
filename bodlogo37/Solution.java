package bodlogo37;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }

         
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }

        
            if (maxHeap.size() == minHeap.size()) {
                System.out.printf("%.1f\n", (maxHeap.peek() + minHeap.peek()) / 2.0);
            } else {
                System.out.printf("%.1f\n", (double) maxHeap.peek());
            }
        }
        sc.close();
    }
}