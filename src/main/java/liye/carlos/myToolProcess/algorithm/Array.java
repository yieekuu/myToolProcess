package liye.carlos.myToolProcess.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by liye3 on 2017/6/27.
 */
public class Array {

    /**
     * Valid Square
     * Given the coordinates of four points in 2D space, return whether the four points could construct a square.
     * The coordinate (x,y) of a point is represented by an integer array with two integers.
     * Example:
     * Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
     * Output: True
     * Note:
     * All the input integers are in the range [-10000, 10000].
     * A valid square has four equal sides with positive length and four equal angles (90-degree angles).
     * Input points have no order.
     * https://leetcode.com/problems/valid-square/#/description
     * 四条边相等，对角线相等。
     */
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        if (p1 == p2 || p2 == null || p3 == null || p4 == null) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        set.add(distanceSquare(p1, p2));
        set.add(distanceSquare(p1, p3));
        set.add(distanceSquare(p1, p4));
        set.add(distanceSquare(p2, p3));
        set.add(distanceSquare(p2, p4));
        set.add(distanceSquare(p3, p4));
        //如果有相同点则肯定不能组成。
        return !set.contains(0) && set.size() == 2;
    }

    private int distanceSquare(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}
