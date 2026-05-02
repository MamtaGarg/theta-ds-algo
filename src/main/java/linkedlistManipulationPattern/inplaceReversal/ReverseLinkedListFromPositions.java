package linkedlistManipulationPattern.inplaceReversal;

public class ReverseLinkedListFromPositions {

    static class Node {
        int data;

        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node reverseLinkedList(Node head, int left, int right) {
        if (head == null || left == right) return head;

        Node dummy = new Node(0);
        dummy.next = head;

        // 1. Move prev to (left - 1)
        Node leftPrev = dummy;
        for (int i = 1; i < left; i++) {
            leftPrev = leftPrev.next;
        }

        // 2. Reverse sublist
        Node prev = null;
        Node curr = leftPrev.next;
        for (int i = 0; i < right - left + 1; i++) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        leftPrev.next.next = curr;
        leftPrev.next = prev;

        return dummy.next;
    }

    private static void printLinkedList(Node head) {
        Node temp = head;
        System.out.println("Linked List : ==============");
        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        //head.next.next.next.next.next = new Node(1);

        printLinkedList(head);

        head = reverseLinkedList(head, 2, 4);

        printLinkedList(head);

    }
}
