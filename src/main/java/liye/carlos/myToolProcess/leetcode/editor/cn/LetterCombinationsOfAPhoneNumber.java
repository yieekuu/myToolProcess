//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics 哈希表 字符串 回溯 👍 2192 👎 0


package liye.carlos.myToolProcess.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<Character, String> digitMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        public List<String> letterCombinations(String digits) {
            if (digits == null || digits.isEmpty()) {
                return new ArrayList<>();
            }
            List<String> combinations = new ArrayList<>();
            backTrack(digits, 0, combinations, new StringBuffer());
            return combinations;
        }

        private void backTrack(String digits,
                               int position,
                               List<String> combinations,
                               StringBuffer combination) {
            if (position == digits.length()) {
                combinations.add(combination.toString());
                return;
            }
            char[] digitsArr = digits.toCharArray();
            String letter = digitMap.get(digitsArr[position]);
            char[] letterArr = letter.toCharArray();
            for (int i = 0; i < letter.length(); i++) {
                combination.append(letterArr[i]);
                backTrack(digits, position + 1, combinations, combination);
                combination.deleteCharAt(position);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}