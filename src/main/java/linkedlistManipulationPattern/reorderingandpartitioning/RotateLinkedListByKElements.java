package linkedlistManipulationPattern.reorderingandpartitioning;

public class RotateLinkedListByKElements {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
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

    public static ListNode rotateListByKNodes(ListNode head, int k) {
        // find number of elements in the LinkedList
        if(head == null || head.next == null || k == 0) return head;

        ListNode tail = head;

        int countNodes = 1;
        while(tail.next != null) {
            countNodes++;
            tail = tail.next;
        }

        tail.next = head;

        k = k % countNodes;

        int stepsToNewTail = countNodes - k - 1;
        ListNode newTail = head;

        for(int i = 0; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        /*head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
*/
        printLinkedList(head);
        head = rotateListByKNodes(head, 3);
        printLinkedList(head);
    }
}
