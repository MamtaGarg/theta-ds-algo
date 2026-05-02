package linkedlistManipulationPattern.inplaceReversal;

public class PalindromeLinkedList {

    static class Node {
        int data;

        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static boolean checkLinkedListPalindrome(Node head) {
        if(head == null) return false;

        // find middle of the linkedlist
        Node slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println("Mid of the list : " + slow.data);
        System.out.println("Next of Mid of the list : " + slow.next.data);
        // Reverse second half linkedlist
        Node current = slow.next;
        Node prev = null;

        while(current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        slow.next = prev;

        System.out.println("LinkedList after reversal : ");
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + ", ");
            temp = temp.next;
        }

        System.out.println();
        Node firstList = head;
        Node secondList = slow.next;
        // Here condition for secondHalf is used. If input is 1->2,
        // if condition is (firstList != slow), then it will return true because slow and firstList both will point to same element,
        // so it will never enter this while loop which is incorrect
        while(secondList != null) {
            if(firstList.data != secondList.data) return false;
            firstList = firstList.next;
            secondList = secondList.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        //head.next.next.next.next.next = new Node(1);

        System.out.println("LinkedList is palindrome : " + checkLinkedListPalindrome(head));

    }
}
