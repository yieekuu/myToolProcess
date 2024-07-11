package liye.carlos.myToolProcess.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liye18
 * @date 2022/2/28.
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] testCase = new int[]{2,7,11,15};
        twoSum(testCase, 9);
    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Map<Integer, Integer> sumMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            Integer tmp = sumMap.get(target - nums[i]);
            if (tmp != null && tmp != i) {
                return new int[]{i, tmp};
            }
            sumMap.put(nums[i], i);
        }
        String s= "";
        s.toCharArray();
        int left,right = 0;
        return null;
    }
}
