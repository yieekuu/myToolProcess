////给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
////
//// 
////
//// 示例 1: 
////
//// 
////输入: s = "abcabcbb"
////输出: 3 
////解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//// 
////
//// 示例 2: 
////
//// 
////输入: s = "bbbbb"
////输出: 1
////解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//// 
////
//// 示例 3: 
////
//// 
////输入: s = "pwwkew"
////输出: 3
////解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//// 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//// 
////
//// 
////
//// 提示： 
////
//// 
//// 0 <= s.length <= 5 * 10⁴ 
//// s 由英文字母、数字、符号和空格组成 
//// 
//// Related Topics 哈希表 字符串 滑动窗口 👍 6986 👎 0
//


  package liye.carlos.myToolProcess.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters{
      public static void main(String[] args) {
           Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

          /**
           * class Solution:
           *     def problemName(self, s: str) -> int:
           *         # Step 1: 定义需要维护的变量们 (对于滑动窗口类题目，这些变量通常是最小长度，最大长度，或者哈希表)
           *         x, y = ..., ...
           *
           *         # Step 2: 定义窗口的首尾端 (start, end)， 然后滑动窗口
           *         start = 0
           *         for end in range(len(s)):
           *             # Step 3: 更新需要维护的变量, 有的变量需要一个if语句来维护 (比如最大最小长度)
           *             x = new_x
           *             if condition:
           *                 y = new_y
           *
           *             '''
           *             ------------- 下面是两种情况，读者请根据题意二选1 -------------
           *             '''
           *             # Step 4 - 情况1
           *             # 如果题目的窗口长度固定：用一个if语句判断一下当前窗口长度是否达到了限定长度
           *             # 如果达到了，窗口左指针前移一个单位，从而保证下一次右指针右移时，窗口长度保持不变,
           *             # 左指针移动之前, 先更新Step 1定义的(部分或所有)维护变量
           *             if 窗口长度达到了限定长度:
           *                 # 更新 (部分或所有) 维护变量
           *                 # 窗口左指针前移一个单位保证下一次右指针右移时窗口长度保持不变
           *
           *             # Step 4 - 情况2
           *             # 如果题目的窗口长度可变: 这个时候一般涉及到窗口是否合法的问题
           *             # 如果当前窗口不合法时, 用一个while去不断移动窗口左指针, 从而剔除非法元素直到窗口再次合法
           *             # 在左指针移动之前更新Step 1定义的(部分或所有)维护变量
           *             while 不合法:
           *                 # 更新 (部分或所有) 维护变量
           *                 # 不断移动窗口左指针直到窗口再次合法
           *
           *         # Step 5: 返回答案
           *         return ...
           */

          public int lengthOfLongestSubstring(String s) {
              if (s == null || "".equals(s)) {
                  return 0;
              }
              //step 1
              Map<Character, Integer> windowMap = new HashMap<>();
              int end = 0, start = 0, ans = 0;
              char[] str = s.toCharArray();
              //step 2
              for (int i = 0; i < s.length(); i++) {
                  //step 3
                  //step 4
                  end = i;
                  if (windowMap.get(str[i]) != null) {
                      start = Math.max(windowMap.get(str[i]), start);
                  }
                  windowMap.put(str[i], end + 1);
                  ans = Math.max(end - start + 1, ans);
              }
              return ans;
          }
}
//leetcode submit region end(Prohibit modification and deletion)

  }