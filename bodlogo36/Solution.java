package bodlogo36;

import java.util.*;

public class Solution {
    static int[] parent;
    static int[] size;

    static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            if (size[rootA] < size[rootB]) {
                int temp = rootA;
                rootA = rootB;
                rootB = temp;
            }
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < m; i++) {
            int op = sc.nextInt();
            int a = sc.nextInt() - 1;

            if (op == 0) {
                int b = sc.nextInt() - 1;
                union(a, b);
            } else if (op == 1) {
                System.out.println(size[find(a)]);
            }
        }
        sc.close();
    }
}