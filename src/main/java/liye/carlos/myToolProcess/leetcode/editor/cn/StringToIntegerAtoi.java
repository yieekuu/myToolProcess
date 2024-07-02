//请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数。
//
// 函数 myAtoi(string s) 的算法如下： 
//
// 
// 空格：读入字符串并丢弃无用的前导空格（" "） 
// 符号：检查下一个字符（假设还未到字符末尾）为 '-' 还是 '+'。如果两者都不存在，则假定结果为正。 
// 转换：通过跳过前置零来读取该整数，直到遇到非数字字符或到达字符串的结尾。如果没有读取数字，则结果为0。 
// 舍入：如果整数数超过 32 位有符号整数范围 [−2³¹, 231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −2³¹ 的整数应
//该被舍入为 −2³¹ ，大于 231 − 1 的整数应该被舍入为 231 − 1 。 
// 
//
// 返回整数作为最终结果。 
//
// 
//
// 示例 1： 
//
// 
// 输入：s = "42" 
// 
//
// 输出：42 
//
// 解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。 
//
// 
//带下划线线的字符是所读的内容，插入符号是当前读入位置。
//第 1 步："42"（当前没有读入字符，因为没有前导空格）
//         ^
//第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
//         ^
//第 3 步："42"（读入 "42"）
//           ^
// 
//
//
// 示例 2： 
//
// 
// 输入：s = " -042" 
// 
//
// 输出：-42 
//
// 解释： 
//
// 
//第 1 步："   -042"（读入前导空格，但忽视掉）
//            ^
//第 2 步："   -042"（读入 '-' 字符，所以结果应该是负数）
//             ^
//第 3 步："   -042"（读入 "042"，在结果中忽略前导零）
//               ^
// 
//
//
// 示例 3： 
//
// 
// 输入：s = "1337c0d3" 
// 
//
// 输出：1337 
//
// 解释： 
//
// 
//第 1 步："1337c0d3"（当前没有读入字符，因为没有前导空格）
//         ^
//第 2 步："1337c0d3"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
//         ^
//第 3 步："1337c0d3"（读入 "1337"；由于下一个字符不是一个数字，所以读入停止）
//             ^
// 
//
//
// 示例 4： 
//
// 
// 输入：s = "0-1" 
// 
//
// 输出：0 
//
// 解释： 
//
// 
//第 1 步："0-1" (当前没有读入字符，因为没有前导空格)
//         ^
//第 2 步："0-1" (当前没有读入字符，因为这里不存在 '-' 或者 '+')
//         ^
//第 3 步："0-1" (读入 "0"；由于下一个字符不是一个数字，所以读入停止)
//          ^
// 
//
//
// 示例 5： 
//
// 
// 输入：s = "words and 987" 
// 
//
// 输出：0 
//
// 解释： 
//
// 读取在第一个非数字字符“w”处停止。 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 200 
// s 由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成 
// 
//
// Related Topics 字符串 👍 1823 👎 0


package liye.carlos.myToolProcess.leetcode.editor.cn;

public class StringToIntegerAtoi {
    public static void main(String[] args) {
        Solution solution = new StringToIntegerAtoi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int myAtoi(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            char[] sChar = s.toCharArray();
            int res = 0;
            int sign = 1;
            int i = 0;
            int length = s.length();
            while (sChar[i] == ' ') {
                if (i == length - 1) {
                    return 0;
                }
                i++;
            }
            if (sChar[i] == '-') {
                sign = -1;
            }
            if (sChar[i] == '-' || sChar[i] == '+') {
                i++;
            }

            for (int j = i; j < length; j++) {
                if (sChar[j] < '0' || sChar[j] > '9') {
                    break;
                }
                if (res > Integer.MAX_VALUE / 10 ||
                        (res == Integer.MAX_VALUE / 10 &&
                                sChar[j] > '7')) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }

                int temp = sChar[j] - '0';
                res = res * 10 + temp;
            }
            return res * sign;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}