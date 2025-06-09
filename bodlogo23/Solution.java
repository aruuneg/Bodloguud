package bodlogo23;

import java.util.*;

public class Solution {
    public static int minMoves(int n) {
        if (n == 0) return 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        queue.add(n);
        visited[n] = true;
        
        int moves = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            moves++;
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                
                // Try subtract 1
                if (current - 1 == 0) return moves;
                if (!visited[current - 1]) {
                    visited[current - 1] = true;
                    queue.add(current - 1);
                }
                
                // Try subtract divisors other than 1 and current itself
                for (int d = 2; d * d <= current; d++) {
                    if (current % d == 0) {
                        int divisor1 = d;
                        int divisor2 = current / d;
                        
                        int next1 = current - divisor1;
                        if (next1 == 0) return moves;
                        if (next1 > 0 && !visited[next1]) {
                            visited[next1] = true;
                            queue.add(next1);
                        }
                        
                        if (divisor2 != divisor1) {
                            int next2 = current - divisor2;
                            if (next2 == 0) return moves;
                            if (next2 > 0 && !visited[next2]) {
                                visited[next2] = true;
                                queue.add(next2);
                            }
                            // If no solution is found, return -1 (should not happen for valid input)
                            return -1;
                        }
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int n = sc.nextInt();
            System.out.println(minMoves(n));
        }
        sc.close();
    }
}
