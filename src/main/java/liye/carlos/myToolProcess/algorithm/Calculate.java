package liye.carlos.myToolProcess.algorithm;

import java.util.HashSet;
import java.util.Set;
import java.lang.String;

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
     * Example 1:
     * Input: “1+1i”, “1+1i”
     * Output: “0+2i”
     * Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
     * Example 2:
     * Input: “1+-1i”, “1+-1i”
     * Output: “0+-2i”
     * Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
     * Note:
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

    /**
     * 326. Power of Three
     * Given an integer, write a function to determine if it is a power of three.
     * Follow up:
     * Could you do it without using any loop / recursion?
     * <p>
     * https://leetcode.com/problems/power-of-three/#/description
     * <p>
     * int -2147483648~2147483647
     * Math.pow(3,19)=1162261467=3^19<2147483647;
     */
    public boolean isPowerOfThree(int n) {
        return !(n <= 0) && (1162261467 % n == 0);
    }

    /**
     * 50. Pow(x, n)
     * <p>
     * Implement pow(x, n).
     * <p>
     * https://leetcode.com/problems/powx-n/#/description
     */
    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            n = -n;
            x = 1 / x;
//            return 1 / (myPow(x, -(n+1))*x);
        }
        return n % 2 == 1 ? (x * myPow(x * x, n / 2)) : (myPow(x * x, n / 2));
    }

    /**
     * 12. Integer to Roman
     * <p>
     * Given an integer, convert it to a roman numeral.
     * <p>
     * Input is guaranteed to be within the range from 1 to 3999.
     * <p>
     * https://leetcode.com/problems/integer-to-roman/#/description
     * I II III IV V VI VII VIII IX X
     * I(1)，V(5)，X(10)，L(50)，C(100)，D(500)，M(1000)
     * 同一字母不能连续出现3次
     * 类似于查表的方式
     */
    public static String intToRoman(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
    }

    /**
     * 29. Divide Two Integers
     * <p>
     * Divide two integers without using multiplication, division and mod operator.
     * <p>
     * If it is overflow, return MAX_INT.
     * <p>
     * https://leetcode.com/problems/divide-two-integers/#/description
     */
    public static int divide(int dividend, int divisor) {
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
            return Integer.MAX_VALUE;
        }
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        long dvd = Math.abs((long)dividend);
        long dvs = Math.abs((long)divisor);
        int result = 0;
        while (dvd >= dvs) {
            int temp = 1;
            long shiftDivisor = dvs;
            while (dvd >= shiftDivisor << 1) {
                shiftDivisor <<= 1;
                temp <<= 1;
            }
            dvd -= shiftDivisor;
            result += temp;
        }

        return sign == 1 ? result : -result;
    }

    public static void main(String[] args) {
        System.out.println(divide(-2147483648,1));
    }

}
