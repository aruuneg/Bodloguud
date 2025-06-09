package bodlogo21;

class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;

    SinglyLinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Solution {

    public static int has_cycle(SinglyLinkedListNode head) {
        if (head == null) return 0;

        SinglyLinkedListNode slow = head;
        SinglyLinkedListNode fast = head.next;

        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return 1;  // cycle detected
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return 0;  // no cycle
    }

    public static void main(String[] args) {
        // Create test linked list with a cycle:
        SinglyLinkedListNode node1 = new SinglyLinkedListNode(1);
        SinglyLinkedListNode node2 = new SinglyLinkedListNode(2);
        SinglyLinkedListNode node3 = new SinglyLinkedListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node1; // cycle here

        System.out.println(has_cycle(node1));  // Output: 1

        // Create linked list without cycle:
        SinglyLinkedListNode nodeA = new SinglyLinkedListNode(1);
        SinglyLinkedListNode nodeB = new SinglyLinkedListNode(2);
        nodeA.next = nodeB;

        System.out.println(has_cycle(nodeA));  // Output: 0
    }
}
