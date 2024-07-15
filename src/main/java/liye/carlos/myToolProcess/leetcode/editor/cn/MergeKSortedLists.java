//给你一个链表数组，每个链表都已经按升序排列。
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
//
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 2842 👎 0


package liye.carlos.myToolProcess.leetcode.editor.cn;

import liye.carlos.myToolProcess.dto.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {

        //最小堆
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }
            //初始化最小堆
            PriorityQueue<ListNode> queue = new PriorityQueue<>((l1,l2)->(l1.val - l2.val));
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    continue;
                }
                queue.add(lists[i]);
            }
            ListNode result = new ListNode(-1);
            ListNode tmp = result;
            while(!queue.isEmpty()){
                    ListNode minNode = queue.poll();
                    tmp.next = minNode;
                    tmp = tmp.next;
                    if(minNode.next!=null) {
                        queue.add(minNode.next);
                    }
            }
            return result.next;

        }


        //分治递归
        public ListNode mergeKLists2(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }
            return merge(lists, 0, lists.length - 1);
        }

        private ListNode merge(ListNode[] lists, int start, int end) {
            if (lists == null) {
                return null;
            }
            if (start == end) {
                return lists[start];
            }
            if (start > end) {
                return null;
            }
            int mid = (start + end) / 2;
            ListNode l1 = merge(lists, start, mid);
            ListNode l2 = merge(lists, mid + 1, end);
            return mergeList(l1, l2);
        }


        ////顺序挨个合并
        public ListNode mergeKLists1(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }
            ListNode result = null;
            for (ListNode list : lists) {
                result = mergeList(result, list);
            }
            return result;
        }

        private ListNode mergeList(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            ListNode result = new ListNode(-1);
            ListNode tmp = result;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    tmp.next = l1;
                    l1 = l1.next;
                } else {
                    tmp.next = l2;
                    l2 = l2.next;
                }
                tmp = tmp.next;
            }
            tmp.next = l1 != null ? l1 : l2;
            return result.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}