package linkedlistManipulationPattern.additionofnumbers;

import linkedlistManipulationPattern.intersectiondetection.IntersectionInTwoLInkedLists;

public class PlusOneLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int data) {
            this.val = data;
        }
    }

    public static ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode lastNonNine = dummy;

        // find rightmost non-9
        ListNode curr = head;
        while (curr != null) {
            if (curr.val != 9) {
                lastNonNine = curr;
            }
            curr = curr.next;
        }

        // increment it
        lastNonNine.val++;

        // make all after it 0
        curr = lastNonNine.next;
        while (curr != null) {
            curr.val = 0;
            curr = curr.next;
        }

        // handle case like 999
        return dummy.val == 0 ? dummy.next : dummy;
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
        head.next = new ListNode(9);
        printLinkedList(head);
        head = plusOne(head);
        printLinkedList(head);
    }
}
