package bodlogo39;

import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord = false;
}

public class Solution {
    private static TrieNode root = new TrieNode();

    private static boolean insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
            if (node.isEndOfWord) {
                // Өмнөх нэр prefix байна
                return false;
            }
        }
        if (!node.children.isEmpty()) {
            // Одоо нэмэх нэр өөрийн prefix боллоо
            return false;
        }
        node.isEndOfWord = true;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String badWord = null;
        boolean goodSet = true;

        for (int i = 0; i < n; i++) {
            String word = sc.next();
            if (goodSet) {
                if (!insert(word)) {
                    goodSet = false;
                    badWord = word;
                }
            }
        }
        sc.close();

        if (goodSet) {
            System.out.println("GOOD SET");
        } else {
            System.out.println("BAD SET");
            System.out.println(badWord);
        }
    }
}