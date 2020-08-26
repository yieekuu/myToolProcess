package liye.carlos.myToolProcess.algorithm;

import liye.carlos.myToolProcess.dto.User;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * Created by liye3 on 2017/7/10.
 */
public class StringALG {

    /**
     * 17. Letter Combinations of a Phone Number
     * <p>
     * Given a digit string, return all possible letter combinations that the number could represent.
     * <p>
     * A mapping of digit to letters (just like on the telephone buttons) is given below.
     * <p>
     * Input:Digit string “23”
     * Output: [“ad”, “ae”, “af”, “bd”, “be”, “bf”, “cd”, “ce”, “cf”].
     * Note:
     * Although the above answer is in lexicographical order, your answer could be in any order you want.
     * <p>
     * https://leetcode.com/problems/letter-combinations-of-a-phone-number/#/description
     */
    public static List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (ans.peek().length() == i) {
                String t = ans.remove();
                for (char s : mapping[x].toCharArray())
                    ans.add(t + s);
            }
        }
        return ans;
    }

    /**
     * 60. Permutation Sequence
     * <p>
     * The set [1,2,3,…,n] contains a total of n! unique permutations.
     * <p>
     * By listing and labeling all of the permutations in order,
     * We get the following sequence (i.e., for n = 3):
     * “123”
     * “132”
     * “213”
     * “231”
     * “312”
     * “321”
     * Given n and k, return the kth permutation sequence.
     * <p>
     * Note: Given n will be between 1 and 9 inclusive.
     * <p>
     * https://leetcode.com/problems/permutation-sequence/#/description
     */
    public static String getPermutation(int n, int k) {
        int pos = 0;
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n + 1];
        StringBuilder sb = new StringBuilder();
        // create an array of factorial lookup
        int sum = 1;
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
            factorial[i] = sum;
        }
        // factorial[] = {1, 1, 2, 6, 24, ... n!}

        // create a list of numbers to get indices
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        // numbers = {1, 2, 3, 4}
        k--;
        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n - i];
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k -= index * factorial[n - i];
        }

        return String.valueOf(sb);
    }

    /**
     * 567. Permutation in String
     * <p>
     * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
     * In other words, one of the first string’s permutations is the substring of the second string.
     * <p>
     * Example 1:
     * Input:s1 = “ab” s2 = “eidbaooo”
     * Output:True
     * Explanation: s2 contains one permutation of s1 (“ba”).
     * Example 2:
     * Input:s1= “ab” s2 = “eidboaoo”
     * Output: False
     * Note:
     * The input strings only contain lower case letters.
     * The length of both given strings is in range [1, 10,000].
     * <p>
     * https://leetcode.com/problems/permutation-in-string/#/description
     */
    public static boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;

        int[] count = new int[26];
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        if (allZero(count)) return true;

        for (int i = len1; i < len2; i++) {
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i - len1) - 'a']++;
            if (allZero(count)) return true;
        }

        return false;
    }

    private static boolean allZero(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }

    /*22. Generate Parentheses
    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
    For example, given n = 3, a solution set is:
            [
            "((()))",
            "(()())",
            "(())()",
            "()(())",
            "()()()"
            ]
    提示：提交代码后，需要用简洁的语言解释一下代码思路~ 谢谢
    历史题目和总结见公众号「每日一道算法题」
    https://leetcode.com/problems/generate-parentheses/description/
    */
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur + "(", open + 1, close, max);
        if (close < open)
            backtrack(ans, cur + ")", open, close + 1, max);
    }

    /*
    409. Longest Palindrome
    Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
    This is case sensitive, for example “Aa” is not considered a palindrome here.
    Note:
    Assume the length of given string will not exceed 1,010.
    Example:
    Input:
            “abccccdd”
    Output:
            7
    Explanation:
    One longest palindrome that can be built is “dccaccd”, whose length is 7.
    提示：提交代码后，需要用简洁的语言解释一下代码思路~ 谢谢
    历史题目和总结见公众号「每日一道算法题」
    https://leetcode.com/problems/longest-palindrome/description/
    */
    public static int longestPalindrome(String s) {
        int result = 0;
        if (s == null) {
            return 0;
        }

        int[] aa = new int[52];
        for (int i = 0; i < s.length(); i++) {
            aa[s.charAt(i) - 'A' > 25 ? s.charAt(i) - 'A' - 6 : s.charAt(i) - 'A']++;
        }

        boolean hasSingle = false;
        for (int j = 0; j < 52; j++) {
            if (aa[j] > 1) {
                result += (aa[j] / 2) * 2;
            }
            if (aa[j] % 2 == 1) {
                hasSingle = true;
            }
        }

        return hasSingle ? result + 1 : result;
    }

    /**
     * @param str string字符串
     * @return int整型
     */
    public static int longestValidParentheses(String str) {
        // write code here
        // write code here
        if (str == null || str.length() <= 1) {
            return 0;
        }
        int n = str.length();
        int maxLength = 0;
        int start = -1;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    start = i;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        maxLength = Math.max(i - start, maxLength);
                    } else {
                        maxLength = Math.max(i - stack.peek(), maxLength);
                    }
                }
            }
        }
        return maxLength;
    }


    public static void main(String[] args) {
        int ssss = longestValidParentheses("))())(()))()(((()())(()(((()))))((()(())()((((()))())))())))()(()(()))))())(((())(()()))((())()())((()))(()(())(())((())((((()())()))((()(())()))()(()))))))()))(()))))()())()())()()()()()()()))()(((()()((()(())((()())))(()())))))))(()()(())())(()))))))()()())((((()()()())))))((())(())()()(()((()()))()()())(()())()))()(()(()())))))())()(())(()))(())()(())()((())()((((()()))())(((((())))())())(()((())((()()((((((())))(((())))))))(()()((((((()(((())()(()))(()())((()(((()((()(())())()())(((()))()(((()))))(())))(())()())()(((()))))((())())))())()()))((((()))(())()())()(((())(())(()()((())()())()()())())))((()())(()((()()()(()())(()))(()())((((()(()(((()(((())()((()(()))())()())))))))))))()())()(()(((())()))(((()))((((()())())(()())((()())(()()((()((((()())))()(())(())()))))(())())))))(((((((())(((((()))()))(()()()()))))))(()(()(()(()()(((()()))((()))())((())())()())()))()()(((())))()(())()()(())))(((()))))))))(())((()((()((()))))()()()((())((((((((((()(())))(())((()(()())())(((((((()()()()))())(((()())()(()()))))(()()))))(((()()((()()()(((()))))(()()())()()()(()))))()(())))))))()((((((((()((())))))))(()))()((()())())(");
//        int ssss = longestValidParentheses("))())(()))()(((");
        System.out.println(ssss);
    }
}
