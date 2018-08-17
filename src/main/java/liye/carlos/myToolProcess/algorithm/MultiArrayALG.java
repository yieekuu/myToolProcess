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
        PriorityQueue < Integer > queue = new PriorityQueue < > ((a, b) -> b - a);
        int time = 0;
        for (int[] c: courses) {
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

public static void main(String[] args){
        int[][] input = {{1,2},{2,3}};
        int result = scheduleCourse(input);
 }
}




































