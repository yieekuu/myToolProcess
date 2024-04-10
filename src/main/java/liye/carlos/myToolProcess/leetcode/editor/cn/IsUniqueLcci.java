//实现一个算法，确定一个字符串 s 的所有字符是否全都不同。 
//
// 示例 1： 
//
// 
//输入: s = "leetcode"
//输出: false 
// 
//
// 示例 2： 
//
// 
//输入: s = "abc"
//输出: true
// 
//
// 限制： 
//
// 
// 0 <= len(s) <= 100 
// s[i]仅包含小写字母 
// 如果你不使用额外的数据结构，会很加分。 
// 
//
// Related Topics 位运算 哈希表 字符串 排序 👍 324 👎 0


package liye.carlos.myToolProcess.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class IsUniqueLcci {
    public static void main(String[] args) {
        Solution solution = new IsUniqueLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isUnique(String astr) {
            if (astr == null || astr.length() == 0) {
                return true;
            }

            int[] dimAttr = new int[26];
            char[] chars = astr.toCharArray();
            for (int i = 0; i < astr.length(); i++) {
                dimAttr[chars[i] - 'a']++;
                if (dimAttr[chars[i] - 'a'] > 1) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}