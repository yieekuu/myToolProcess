package liye.carlos.myToolProcess.algorithm;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by liye3 on 2017/6/27.
 */
public class Calculate {

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


    /**
     * 537. Complex Number Multiplication
     * Given two strings representing two complex numbers.
     * You need to return a string representing their multiplication. Note i2 = -1 according to the definition.
     * <p>
     * Example 1:
     * <p>
     * Input: “1+1i”, “1+1i”
     * Output: “0+2i”
     * Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
     * <p>
     * Example 2:
     * <p>
     * Input: “1+-1i”, “1+-1i”
     * Output: “0+-2i”
     * Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
     * <p>
     * Note:
     * <p>
     * 1. The input strings will not have extra blank.
     * 2. The input strings will be given in the form of a+bi, where the integer a and b will both belong to the range of [-100, 100]. And the output should be also in this form.
     * <p>
     * https://leetcode.com/problems/complex-number-multiplication/#/description
     */
    public static String complexNumberMultiply(String a, String b) {
        if (a == null || b == null) {
            return null;
        }
        String[] num1 = a.split("\\+");
        String[] num2 = b.split("\\+");
        int num1Left = Integer.parseInt(num1[0]);
        int num1Right = 0;
        if (num1.length > 1) {
            num1Right = Integer.parseInt(num1[1].split("i")[0]);
        }

        int num2Left = Integer.parseInt(num2[0]);
        int num2Right = 0;
        if (num1.length > 1) {
            num2Right = Integer.parseInt(num2[1].split("i")[0]);
        }
        int resultLeft = num1Left * num2Left - num1Right * num2Right;
        int resultRight = num1Left * num2Right + num1Right * num2Left;
        return resultLeft + "+" + resultRight + "i";
    }

    public static void main(String[] args) {
        complexNumberMultiply("1+1i","1+1i");
    }

}
