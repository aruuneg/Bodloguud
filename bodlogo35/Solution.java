package bodlogo35;

import java.util.*;

public class Solution {
    static int n;
    static int[] values;
    static List<Integer>[] tree;
    static int[] xorSubtree;
    static long result = 0;

    static int dfs(int node) {
        int xorVal = values[node];
        for (int child : tree[node]) {
            xorVal ^= dfs(child);
        }
        xorSubtree[node] = xorVal;
        result += xorVal;
        return xorVal;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }

        tree = (ArrayList<Integer>[]) new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            int parent = sc.nextInt() - 1; 
            tree[parent].add(i);
        }

        xorSubtree = new int[n];
        dfs(0);

        System.out.println(result);

        sc.close();
    }
}