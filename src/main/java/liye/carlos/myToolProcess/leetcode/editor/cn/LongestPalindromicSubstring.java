//给你一个字符串 s，找到 s 中最长的 回文 子串。
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 双指针 字符串 动态规划 👍 7255 👎 0


package liye.carlos.myToolProcess.leetcode.editor.cn;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //        public String longestPalindrome(String s) {
//            if (s.length() == 1) {
//                return s;
//            }
//
//            int left = 0;
//            int right = 0;
//            char[] charStr = s.toCharArray();
//            for (int i = 0; i < s.length(); i++) {
//                for (int j = i; j < s.length(); j++) {
//                    if (isSubStrHuiWen(charStr, i, j)) {
//                        if (j > i && j - i > right - left) {
//                            left = i;
//                            right = j;
//                        }
//                    }
//
//                }
//            }
//
////            return "" + left + right;
//            return s.substring(left, right + 1);
//
//        }
//
//        private boolean isSubStrHuiWen(char[] subStr, int start, int end) {
//            int length = end - start + 1;
//            for (int i = start; i < start + length / 2; i++) {
//                if (subStr[i] != subStr[end - i + start]) {
//                    return false;
//                }
//            }
//            return true;
//        }
//
//
        public String longestPalindrome(String s) {

            if (s.length() == 1) {
                return s;
            }

            //奇数回文、偶数回文
            int start = 0;
            int end = 0;
            for (int i = 0; i < s.length(); i++) {
                //奇数
                int len1 = lengthOfHuiWen(s, i, i);
                //偶数
                int len2 = lengthOfHuiWen(s, i, i + 1);
                int tempLen = Math.max(len1, len2);
                if (tempLen > end - start + 1) {
                    start = i - (tempLen - 1) / 2;
                    end = start + tempLen - 1;
                }
            }

            return s.substring(start, end + 1);

        }

        private int lengthOfHuiWen(String s, int left, int right) {
            char[] charStr = s.toCharArray();
            while (left >= 0 && right < s.length() && charStr[left] == charStr[right]) {
                left--;
                right++;
            }
            return right - left - 1;

        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}