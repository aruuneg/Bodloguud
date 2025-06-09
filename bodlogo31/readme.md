# Бодлого 31 - Is This a Binary Search Tree?

## Бодлогын өгүүлбэр:  
Өгөгдсөн бинар мод нь Binary Search Tree (BST) эсэхийг шалгаарай. BST-ийн бүх зангилаануудын баруун хүүхэд нь түүнээс илүү буюу тэнцүү утгатай, зүүн хүүхэд нь түүнээс бага утгатай байх шаардлагатай.

## Холбоос:  
[https://www.hackerrank.com/challenges/is-binary-search-tree/problem](https://www.hackerrank.com/challenges/is-binary-search-tree/problem)

## Шийдэл:  
- Модны бүх зангилааг inorder traversal хийж, гарсан дараалал өсөх дараалалтай эсэхийг шалгах.  
- Мөн recursive функц ашиглан тухайн зангилаанд зөв дээд доод хязгаар тавьж, бүх хүүхдүүд хязгаарын дотор байгаа эсэхийг шалгах боломжтой.

---

```java
class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Solution {
    static boolean isBST(Node root) {
        return isBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    static boolean isBSTUtil(Node node, long min, long max) {
        if (node == null) return true;
        if (node.data <= min || node.data >= max) return false;
        return isBSTUtil(node.left, min, node.data) &&
               isBSTUtil(node.right, node.data, max);
    }

    public static void main(String[] args) {
        // Example test case
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        System.out.println(isBST(root) ? "YES" : "NO");
    }
}
