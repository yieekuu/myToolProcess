//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 3616 👎 0


package liye.carlos.myToolProcess.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();

            generate(result, new StringBuilder(), 0, 0, n);

            return result;
        }

        private void generate(List<String> result, StringBuilder current, int open, int closed, int n) {
            if (current.length() == n * 2) {
                result.add(current.toString());
                return;
            }
            if (open < n) {
                current.append("(");
                generate(result, current, open + 1, closed, n);
                current.deleteCharAt(current.length() - 1);
            }
            if (closed < open) {
                current.append(")");
                generate(result, current, open, closed + 1, n);
                current.deleteCharAt(current.length() - 1);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}