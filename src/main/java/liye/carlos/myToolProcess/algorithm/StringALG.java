package liye.carlos.myToolProcess.algorithm;

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

    public static void main(String[] args) {

        System.out.println(checkInclusion("ab", "eaidbaoo"));
    }
}
