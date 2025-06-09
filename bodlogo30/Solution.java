package bodlogo30;

import java.io.*;
import java.util.*;

public class Solution {
    static class Node {
        int left, right;
        Node(int l, int r) {
            this.left = l;
            this.right = r;
        }
    }

    static List<Node> tree = new ArrayList<>();
    static List<List<Integer>> results = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree.add(null); // 1-indexed

        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().split(" ");
            int left = Integer.parseInt(parts[0]);
            int right = Integer.parseInt(parts[1]);
            tree.add(new Node(left, right));
        }

        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            int k = Integer.parseInt(br.readLine());
            swapAtDepth(1, 1, k);
            List<Integer> res = new ArrayList<>();
            inorder(1, res);
            results.add(res);
        }

        StringBuilder sb = new StringBuilder();
        for (List<Integer> res : results) {
            for (int val : res) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    static void swapAtDepth(int index, int depth, int k) {
        if (index == -1) return;

        if (depth % k == 0) {
            Node node = tree.get(index);
            int temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        swapAtDepth(tree.get(index).left, depth + 1, k);
        swapAtDepth(tree.get(index).right, depth + 1, k);
    }

    static void inorder(int index, List<Integer> res) {
        if (index == -1) return;
        inorder(tree.get(index).left, res);
        res.add(index);
        inorder(tree.get(index).right, res);
    }
}
