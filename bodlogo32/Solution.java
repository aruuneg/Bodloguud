package bodlogo32;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);  // Number of nodes
        int m = Integer.parseInt(nm[1]);  // Number of edges

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

     
        for (int i = 0; i < m; i++) {
            String[] edge = br.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n + 1];
        int components = 0;

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                components++;
                dfs(i, graph, visited);
            }
        }

        System.out.println(components);
    }

    static void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        for (int adj : graph.get(node)) {
            if (!visited[adj]) {
                dfs(adj, graph, visited);
            }
        }
    }
}
