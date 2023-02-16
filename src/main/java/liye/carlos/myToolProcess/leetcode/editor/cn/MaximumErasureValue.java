//给你一个正整数数组 nums ，请你从中删除一个含有 若干不同元素 的子数组。删除子数组的 得分 就是子数组各元素之 和 。 
//
// 返回 只删除一个 子数组可获得的 最大得分 。 
//
// 如果数组 b 是数组 a 的一个连续子序列，即如果它等于 a[l],a[l+1],...,a[r] ，那么它就是 a 的一个子数组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,2,4,5,6]
//输出：17
//解释：最优子数组是 [2,4,5,6]
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,2,1,2,5,2,1,2,5]
//输出：8
//解释：最优子数组是 [5,2,1] 或 [1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 哈希表 滑动窗口 👍 63 👎 0

  
  package liye.carlos.myToolProcess.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class MaximumErasureValue{
      public static void main(String[] args) {
           Solution solution = new MaximumErasureValue().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          public int maximumUniqueSubarray(int[] nums) {
              int result = 0;
              int tmp = 0;
              int left = 0;
              Map<Integer, Integer> subMap = new HashMap<>();
              for (int i = 0; i < nums.length; i++) {
                  if (subMap.get(nums[i]) != null) {
                      while (left < i) {
                          int a = subMap.get(nums[left]);
                          subMap.remove(nums[left]);
                          tmp -= a;
                          left++;
                          if (a == nums[i]) {
                              break;
                          }
                      }
                  }
                  subMap.put(nums[i], nums[i]);
                  tmp += nums[i];
                  result = Math.max(result, tmp);
              }
              return result;

          }
}
//leetcode submit region end(Prohibit modification and deletion)

  }