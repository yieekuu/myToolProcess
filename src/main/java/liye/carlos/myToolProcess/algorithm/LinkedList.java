package liye.carlos.myToolProcess.algorithm;

/**
 * Created by liye3 on 2017/6/19.
 */
public class LinkedList {


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * Given a linked list, determine if it has a cycle in it.
     * <p>
     * Follow up:
     * Can you solve it without using extra space?
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return false;
        }
        ListNode front = head;
        ListNode behind = head;
        while (front != null && front.next != null) {
            front = front.next.next;
            behind = behind.next;
            if (front == behind) {
                return true;
            }
        }
        return false;
    }

    /**
     * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
     * <p>
     * You should preserve the original relative order of the nodes in each of the two partitions.
     * <p>
     * For example,
     * Given 1->4->3->2->5->2 and x = 3,
     * return 1->2->2->4->3->5.
     */
    public static ListNode partitionList(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode small = new ListNode(0);
        ListNode big = new ListNode(0);
        ListNode smallHead = small;
        ListNode bigHead = big;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            }else {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        big.next = null;
        small.next = bigHead.next;
        return smallHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        ListNode result = partitionList(head, 0);
        while (result != null && result.next != null) {
            System.out.println(result);
            result = result.next;
        }
    }
}
