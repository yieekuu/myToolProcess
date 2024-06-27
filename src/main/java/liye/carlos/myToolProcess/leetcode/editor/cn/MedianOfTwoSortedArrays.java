//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
//
// Related Topics 数组 二分查找 分治 👍 7109 👎 0


package liye.carlos.myToolProcess.leetcode.editor.cn;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            //中位数左边
            int left = (m + n + 1) / 2;
            int right = (m + n) / 2 + 1;
            return (getKth(nums1, 0, m - 1, nums2, 0, n - 1, left) +
                    getKth(nums1, 0, m - 1, nums2, 0, n - 1, right)) * 0.5;
        }


        /**
         * 获取两个数组中第k小数字
         */
        private int getKth(int[] num1, int start1, int end1, int[] num2, int start2, int end2, int k) {
            //两个数组长度不一，固定让num1最短
            int len1 = end1 - start1 + 1;
            int len2 = end2 - start2 + 1;
            if (len2 < len1) return getKth(num2, start2, end2, num1, start1, end1, k);

            //如果num1长度为0，返回num2[k+start2-1]
            if (len1 == 0) return num2[start2 + k - 1];

            if (k == 1) return Math.min(num1[start1], num2[start2]);

            //每次递归找min(num1[min(k/2, len1)], num2[min(k/2, len2)])小数字
            int i = Math.min(len1, k / 2);
            int j = Math.min(len2, k / 2);

            //num1[i]小，则去掉num1中的前i个数字
            if (num1[start1 + i - 1] > num2[start2 + j - 1]) {
                return getKth(num1, start1, end1, num2, start2 + j, end2, k - j);
            } else {
                return getKth(num1, start1 + i, end1, num2, start2, end2, k - i);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}