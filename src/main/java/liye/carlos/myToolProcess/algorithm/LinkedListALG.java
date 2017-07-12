package liye.carlos.myToolProcess.algorithm;

import java.util.*;

/**
 * Created by liye3 on 2017/6/19.
 */
public class LinkedListALG {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    /**
     * Given a linked list, determine if it has a cycle in it.
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
     * You should preserve the original relative order of the nodes in each of the two partitions.
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
            } else {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        big.next = null;
        small.next = bigHead.next;
        return smallHead.next;
    }

    /**
     * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return toBST(head, null);

    }

    private TreeNode toBST(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;
        if (head == tail) return null;

        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode thead = new TreeNode(slow.val);
        thead.left = toBST(head, slow);
        thead.right = toBST(slow.next, tail);
        return thead;
    }

    /**
     * Remove Duplicates from Sorted List
     * Given a sorted linked list, delete all duplicates such that each element appear only once.
     * For example,
     * Given 1->1->2, return 1->2.
     * Given 1->1->2->3->3, return 1->2->3.
     * https://leetcode.com/problems/remove-duplicates-from-sorted-list/#/description
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }

    /**
     * Add Two Numbers
     * You are given two non-empty linked lists representing two non-negative integers.
     * The digits are stored in reverse order and each of their nodes contain a single digit.
     * Add the two numbers and return it as a linked list.
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * https://leetcode.com/problems/add-two-numbers/#/description
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {

            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
            sum = (sum - sum % 10) / 10;
        }
        if (sum != 0)
            d.next = new ListNode(sum);
        return sentinel.next;
    }

    /**
     * 92. Reverse Linked List II
     * Reverse a linked list from position m to n. Do it in-place and in one-pass.
     * For example:
     * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
     * return 1->4->3->2->5->NULL.
     * Note:
     * Given m, n satisfy the following condition:
     * 1 ≤ m ≤ n ≤ length of list.
     * https://leetcode.com/problems/reverse-linked-list-ii/#/description
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode pre = result; // make a pointer pre as a marker for the node before reversing
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
        ListNode then = start.next; // a pointer to a node that will be reversed
        // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
        // result-> 1 -> 2 -> 3 -> 4 -> 5
        for (int i = 0; i < n - m; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        // first reversing : result->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
        // second reversing: result->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)
        return result.next;
    }

    /**
     * 632. Smallest Range
     * You have k lists of sorted integers in ascending order.
     * Find the smallest range that includes at least one number from each of the k lists.
     * <p>
     * We define the range [a,b] is smaller than range [c,d] if b-a < d-c or a < c if b-a == d-c.
     * <p>
     * Example 1:
     * Input:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
     * Output: [20,24]
     * Explanation:
     * List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
     * List 2: [0, 9, 12, 20], 20 is in range [20,24].
     * List 3: [5, 18, 22, 30], 22 is in range [20,24].
     * Note:
     * The given list may contain duplicates, so ascending order means >= here.
     * 1 <= k <= 3500
     * -105 <= value of elements <= 105.
     * For Java users, please note that the input type has been changed to List<List<Integer>>.
     * And after you reset the code template, you’ll see this point.
     * <p>
     * https://leetcode.com/problems/smallest-range/#/description
     */

    public static int[] smallestRange(List<List<Integer>> nums) {
        class Element {
            private int row;
            private int idx;
            private int val;

            private Element(int r, int i, int v) {
                row = r;
                idx = i;
                val = v;
            }
        }
        PriorityQueue<Element> pq = new PriorityQueue<>(new Comparator<Element>() {
            public int compare(Element a, Element b) {
                return a.val - b.val;
            }
        });
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            Element e = new Element(i, 0, nums.get(i).get(0));
            pq.offer(e);
            max = Math.max(max, nums.get(i).get(0));
        }
        int range = Integer.MAX_VALUE;
        int start = -1, end = -1;
        while (pq.size() == nums.size()) {
            Element curr = pq.poll();
            if (max - curr.val < range) {
                range = max - curr.val;
                start = curr.val;
                end = max;
            }
            if (curr.idx + 1 < nums.get(curr.row).size()) {
                curr.idx = curr.idx + 1;
                curr.val = nums.get(curr.row).get(curr.idx);
                pq.offer(curr);
                if (curr.val > max) {
                    max = curr.val;
                }
            }
        }

        return new int[]{start, end};
    }


    public static void main(String[] args) {

        System.out.println("");
    }
}
