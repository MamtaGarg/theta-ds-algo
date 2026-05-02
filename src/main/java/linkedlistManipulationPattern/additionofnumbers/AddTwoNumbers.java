package linkedlistManipulationPattern.additionofnumbers;


public class AddTwoNumbers {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int data) {
            this.val = data;
        }
    }

    public static ListNode addTwoNumbers(ListNode head1, ListNode head2) {

        ListNode l1 = head1;
        ListNode l2 = head2;
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while(l1 != null || l2 != null || carry != 0) {
            int sum = 0;
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            sum = val1 + val2 + carry;
            carry = sum / 10;

            current.next = new ListNode(sum % 10);
            current = current.next;
            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
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
        ListNode headA = new ListNode(5);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(8);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);
        headA.next.next.next.next.next = new ListNode(6);


        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);

        printLinkedList(headA);
        printLinkedList(headB);

        ListNode node = addTwoNumbers(headA, headB);
        printLinkedList(node);
    }
}
