package linkedlistManipulationPattern.inplaceReversal;

public class RemoveDuplicatesFromSortedList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int data) {
            this.val = data;
        }
    }

    public static void removeDuplicates(ListNode head) {
        ListNode temp = head;
        while(temp != null && temp.next != null) {
            while(temp.next != null && temp.val == temp.next.val) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
    }

    private static void printLinkedList(ListNode head) {
        ListNode temp = head;
        System.out.println("Linked List : ==============");
        while(temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        printLinkedList(head);
        removeDuplicates(head);
        printLinkedList(head);

    }
}
