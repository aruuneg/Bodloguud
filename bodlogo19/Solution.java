package bodlogo19;

import java.io.*;
import java.util.*;

public class Solution {

    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    // Dijkstra algorithm
    static int dijkstra(int start, int end, Map<Integer, List<Edge>> graph, int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0], distance = current[1];

            if (node == end) return distance;

            if (graph.containsKey(node)) {
                for (Edge edge : graph.get(node)) {
                    int next = edge.to, weight = edge.weight;
                    if (dist[next] > distance + weight) {
                        dist[next] = distance + weight;
                        pq.add(new int[]{next, dist[next]});
                    }
                }
            }
        }

        return -1; // unreachable
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] roadNodesEdges = bufferedReader.readLine().trim().split(" ");
        int roadNodes = Integer.parseInt(roadNodesEdges[0]);
        int roadEdges = Integer.parseInt(roadNodesEdges[1]);

        Map<Integer, List<Edge>> graph = new HashMap<>();

        for (int i = 0; i < roadEdges; i++) {
            String[] parts = bufferedReader.readLine().trim().split(" ");
            int from = Integer.parseInt(parts[0]);
            int to = Integer.parseInt(parts[1]);
            int weight = Integer.parseInt(parts[2]);

            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(new Edge(to, weight));
            graph.computeIfAbsent(to, k -> new ArrayList<>()).add(new Edge(from, weight)); // Undirected
        }

        int q = Integer.parseInt(bufferedReader.readLine().trim());
        for (int i = 0; i < q; i++) {
            String[] query = bufferedReader.readLine().trim().split(" ");
            int x = Integer.parseInt(query[0]);
            int y = Integer.parseInt(query[1]);

            int result = dijkstra(x, y, graph, roadNodes);
            System.out.println(result);
        }

        bufferedReader.close();
    }
}
