package bodlogo24;

class Node {
    int frequency;
    char data;
    Node left, right;
}

class HuffmanDecoder {
    public static void decode(String s, Node root) {
        Node current = root;
        for (int i = 0; i < s.length(); i++) {
            char bit = s.charAt(i);
            if (bit == '0') {
                current = current.left;
            } else {
                current = current.right;
            }
            
            if (current.left == null && current.right == null) {
                System.out.print(current.data);
                current = root;
            }
        }
    }
}

public class Solution {
    public static void main(String[] args) {
      
    }
}
