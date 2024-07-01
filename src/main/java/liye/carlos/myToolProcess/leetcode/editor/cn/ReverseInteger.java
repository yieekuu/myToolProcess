//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−2³¹, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
//
// Related Topics 数学 👍 3998 👎 0


package liye.carlos.myToolProcess.leetcode.editor.cn;

public class ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new ReverseInteger().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            int result = 0;
//        Integer.MAX_VALUE
            //123
            while (x != 0) {
                int temp = x % 10;
                x = x / 10;
                if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && temp > Integer.MAX_VALUE % 10)) {
                    return 0;
                }
                if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && temp < Integer.MIN_VALUE % 10)) {
                    return 0;
                }
                result = result * 10 + temp;
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}