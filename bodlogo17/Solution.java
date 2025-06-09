package bodlogo17;

import java.io.*;
import java.util.*;

class Result {

    public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int s) {
        // Графыг хөршийн жагсаалт хэлбэрээр үүсгэнэ
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);

            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{s, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int d = current[1];

            if (d > dist[node]) continue;

            for (int[] neighbor : graph.get(node)) {
                int next = neighbor[0];
                int weight = neighbor[1];

                if (dist[node] + weight < dist[next]) {
                    dist[next] = dist[node] + weight;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i == s) continue;
            result.add(dist[i] == Integer.MAX_VALUE ? -1 : dist[i]);
        }

        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        // INPUT example (you can use Scanner instead for testing)
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String[] firstInput = bufferedReader.readLine().split(" ");
            int n = Integer.parseInt(firstInput[0]);
            int m = Integer.parseInt(firstInput[1]);

            List<List<Integer>> edges = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                String[] edgeParts = bufferedReader.readLine().split(" ");
                List<Integer> edge = new ArrayList<>();
                for (String part : edgeParts) {
                    edge.add(Integer.parseInt(part));
                }
                edges.add(edge);
            }

            int s = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> result = Result.shortestReach(n, edges, s);
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i));
                if (i != result.size() - 1) System.out.print(" ");
            }
            System.out.println();
        }

        bufferedReader.close();
    }
}
