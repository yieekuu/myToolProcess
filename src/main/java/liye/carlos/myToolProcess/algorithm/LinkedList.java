package liye.carlos.myToolProcess.algorithm;

/**
 * Created by liye3 on 2017/6/19.
 */
public class LinkedList {


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }
        ListNode front = head;
        ListNode behind = head;
        while (head.next != null && head.next.next != null) {
            front = head.next.next;
            behind = head.next;
            head = head.next;
            if (front == behind) {
                return true;
            }
        }
        return false;
    }
}
