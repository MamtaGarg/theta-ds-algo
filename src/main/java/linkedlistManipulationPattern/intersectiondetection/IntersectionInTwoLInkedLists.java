package linkedlistManipulationPattern.intersectiondetection;

import linkedlistManipulationPattern.inplaceReversal.RemoveDuplicatesEntirelyFromLinkedList;

public class IntersectionInTwoLInkedLists {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int data) {
            this.val = data;
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        while(tempA != tempB) {
            if(tempA == null) {
                tempA = headB;
            } else {
                tempA = tempA.next;
            }
            if(tempB == null) {
                tempB = headA;
            } else {
                tempB = tempB.next;
            }
        }
        return tempA;
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
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(8);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);
        headA.next.next.next.next.next = new ListNode(6);


        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next =  headA.next.next;

        printLinkedList(headA);
        printLinkedList(headB);

        ListNode node = getIntersectionNode(headA, headB);
        System.out.println("Common intersection point : " + node.val);
    }
}
