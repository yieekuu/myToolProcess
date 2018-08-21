package liye.carlos.myToolProcess.algorithm;

import java.util.*;

/**
 * Created by liye18 on 2018/8/16.
 */
public class MultiArrayALG {

    /**
     * 630. Course Schedule III
     * There are n different online courses numbered from 1 to n. Each course has some duration(course length) t and closed on dth day. A course should be taken continuously for t days and must be finished before or on the dth day. You will start at the 1st day.
     * Given n online courses represented by pairs (t,d), your task is to find the maximal number of courses that can be taken.
     * 提示：提交代码后，需要用简洁的语言解释一下代码思路~ 谢谢
     * 历史题目和总结见公众号「每日一道算法题」
     * https://leetcode.com/problems/course-schedule-iii/description/
     */
    public static int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int time = 0;
        for (int[] c : courses) {
            if (time + c[0] <= c[1]) {
                queue.offer(c[0]);
                time += c[0];
            } else if (!queue.isEmpty() && queue.peek() > c[0]) {
                time += c[0] - queue.poll();
                queue.offer(c[0]);
            }
        }
        return queue.size();
    }

    /**
     * 78. Subsets
     * Given a set of distinct integers, nums, return all possible subsets (the power set).
     * Note: The solution set must not contain duplicate subsets.
     * Example:
     * Input: nums = [1,2,3]
     * Output:
     * [
     * [3],
     * [1],
     * [2],
     * [1,2,3],
     * [1,3],
     * [2,3],
     * [1,2],
     * []
     * ]
     * 提示：提交代码后，需要用简洁的语言解释一下代码思路~ 谢谢
     * 历史题目和总结见公众号「每日一道算法题」
     * https://leetcode.com/problems/subsets/description/
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int num : nums) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> tmp = new ArrayList<>();
                tmp.addAll(result.get(i));
                tmp.add(num);
                result.add(tmp);
            }
            List<Integer> addNum = new ArrayList<>();
            addNum.add(num);
            result.add(addNum);
        }
        result.add(new ArrayList<>());

        return result;
    }

    public static List<List<Integer>> subsets2(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }
        int size = nums.length;
        int resultSize = (int) Math.pow(2, size);
        List<List<Integer>> result = new ArrayList<List<Integer>>(resultSize);
        for (int i = 0; i < resultSize; i++) {
            result.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < resultSize; j++) {
                if ((j >> i & 1) == 0) {
                    result.get(j).add(nums[i]);
                }
            }
        }

        return result;
    }


}




































