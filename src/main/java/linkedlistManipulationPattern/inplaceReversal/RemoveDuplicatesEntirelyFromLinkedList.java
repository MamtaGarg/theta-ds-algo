package linkedlistManipulationPattern.inplaceReversal;

public class RemoveDuplicatesEntirelyFromLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int data) {
            this.val = data;
        }
    }

    private static ListNode removeDuplicatesEntirely(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode current = head;

        while(current != null) {

            boolean isDuplicate = false;
            while(current.next != null && current.val == current.next.val) {
                isDuplicate = true;
                current = current.next;
            }
            if(isDuplicate) {
                prev.next = current.next;
            } else {
                prev = prev.next;
            }
            current = current.next;
        }
        return dummy.next;
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
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        printLinkedList(head);
        head = removeDuplicatesEntirely(head);
        printLinkedList(head);

    }
}
