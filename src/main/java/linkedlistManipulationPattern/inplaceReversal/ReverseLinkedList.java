package linkedlistManipulationPattern.inplaceReversal;

public class ReverseLinkedList {

    static class Node {
        int data;

        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node reverseLinkedList(Node head) {
        Node prev = null;
        Node current = head;
        while(current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
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

        head = reverseLinkedList(head);

        printLinkedList(head);

    }
}
