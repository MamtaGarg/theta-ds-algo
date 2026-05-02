package linkedlistManipulationPattern.inplaceReversal;

public class ReverseNodesInKGroup {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int data) {
            this.val = data;
        }
    }

    private static ListNode reverseNodesInkGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupEnd = dummy;

        while (true) {
            // 1. Find kth node
            ListNode kth = prevGroupEnd;
            for (int i = 0; i < k && kth != null; i++) {
                kth = kth.next;
            }

            if (kth == null) break;

            ListNode groupStart = prevGroupEnd.next;
            ListNode nextGroupStart = kth.next;

            // 2. Reverse group
            ListNode prev = nextGroupStart;
            ListNode curr = groupStart;

            while (curr != nextGroupStart) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // 3. Connect
            prevGroupEnd.next = kth;
            prevGroupEnd = groupStart;
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
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);

        int k = 2;

        printLinkedList(head);
        head = reverseNodesInkGroup(head, k) ;
        printLinkedList(head);
    }

}
