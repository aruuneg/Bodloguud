package bodlogo34;

import java.util.*;

public class Solution {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        int count = 0;
    }

    static TrieNode root = new TrieNode();

    static void add(String name) {
        TrieNode node = root;
        for (char c : name.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
            node.count++;
        }
    }

    static int find(String partial) {
        TrieNode node = root;
        for (char c : partial.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return 0;
            }
            node = node.children.get(c);
        }
        return node.count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();
        for (int i = 0; i < Q; i++) {
            String op = sc.next();
            String arg = sc.next();
            if (op.equals("add")) {
                add(arg);
            } else if (op.equals("find")) {
                System.out.println(find(arg));
            }
        }
        sc.close();
    }
}
