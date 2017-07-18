package liye.carlos.myToolProcess.algorithm;

import java.util.*;

/**
 * Created by liye3 on 2017/7/7.
 */
public class Array {

    /**
     * 81. Search in Rotated Sorted Array II
     * <p>
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     * <p>
     * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
     * <p>
     * Write a function to determine if a given target is in the array.
     * <p>
     * The array may contain duplicates.
     * <p>
     * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/#/description
     */
    public boolean search(int[] nums, int target) {
        if (nums.length < 1) {
            return false;
        }
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low < high) {
            mid = (low + high) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > nums[high]) {
                if (nums[mid] > target && nums[low] <= target) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] < nums[high]) {
                if (nums[mid] < target && nums[high] >= target) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            } else {
                high--;
            }
        }
        return nums[low] == target;
    }

    /**
     * 532. K-diff Pairs in an Array
     * <p>
     * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.
     * <p>
     * Example 1:
     * Input: [3, 1, 4, 1, 5], k = 2
     * Output: 2
     * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
     * Although we have two 1s in the input, we should only return the number of unique pairs.
     * Example 2:
     * Input:[1, 2, 3, 4, 5], k = 1
     * Output: 4
     * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
     * Example 3:
     * Input: [1, 3, 1, 5, 4], k = 0
     * Output: 1
     * Explanation: There is one 0-diff pair in the array, (1, 1).
     * Note:
     * The pairs (i, j) and (j, i) count as the same pair.
     * The length of the array won’t exceed 10,000.
     * All the integers in the given input belong to the range: [-1e7, 1e7].
     * <p>
     * https://leetcode.com/problems/k-diff-pairs-in-an-array/#/description
     */
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                //count how many elements in the array that appear more than twice.
                if (entry.getValue() >= 2) {
                    count++;
                }
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * 18. 4Sum
     * <p>
     * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
     * <p>
     * Note: The solution set must not contain duplicate quadruplets.
     * <p>
     * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
     * <p>
     * A solution set is:
     * [
     * [-1,  0, 0, 1],
     * [-2, -1, 1, 2],
     * [-2,  0, 0, 2]
     * ]
     * <p>
     * https://leetcode.com/problems/4sum/#/description
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 4)
            return res;

        Arrays.sort(nums);
        int max = nums[len - 1];
        if (4 * nums[0] > target || 4 * max < target)
            return res;

        int i, z;
        for (i = 0; i < len; i++) {
            z = nums[i];
            if (i > 0 && z == nums[i - 1])// avoid duplicate
                continue;
            if (z + 3 * max < target) // z is too small
                continue;
            if (4 * z > target) // z is too large
                break;
            if (4 * z == target) { // z is the boundary
                if (i + 3 < len && nums[i + 3] == z)
                    res.add(Arrays.asList(z, z, z, z));
                break;
            }

            threeSumForFourSum(nums, target - z, i + 1, len - 1, res, z);
        }
        return res;

    }

    /**
     * Find all possible distinguished three numbers adding up to the target
     * in sorted array nums[] between indices low and high. If there are,
     * add all of them into the ArrayList fourSumList, using
     * fourSumList.add(Arrays.asList(z1, the three numbers))
     */
    private static void threeSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
                                           int z1) {
        if (low + 1 >= high)
            return;

        int max = nums[high];
        if (3 * nums[low] > target || 3 * max < target)
            return;

        int i, z;
        for (i = low; i < high - 1; i++) {
            z = nums[i];
            if (i > low && z == nums[i - 1]) // avoid duplicate
                continue;
            if (z + 2 * max < target) // z is too small
                continue;

            if (3 * z > target) // z is too large
                break;

            if (3 * z == target) { // z is the boundary
                if (i + 1 < high && nums[i + 2] == z)
                    fourSumList.add(Arrays.asList(z1, z, z, z));
                break;
            }

            twoSumForFourSum(nums, target - z, i + 1, high, fourSumList, z1, z);
        }

    }

    /**
     * Find all possible distinguished two numbers adding up to the target
     * in sorted array nums[] between indices low and high. If there are,
     * add all of them into the ArrayList fourSumList, using
     * fourSumList.add(Arrays.asList(z1, z2, the two numbers))
     */
    private static void twoSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
                                         int z1, int z2) {

        if (low >= high)
            return;

        if (2 * nums[low] > target || 2 * nums[high] < target)
            return;

        int i = low, j = high, sum, x;
        while (i < j) {
            sum = nums[i] + nums[j];
            if (sum == target) {
                fourSumList.add(Arrays.asList(z1, z2, nums[i], nums[j]));

                x = nums[i];
                while (++i < j && x == nums[i]) // avoid duplicate
                    ;
                x = nums[j];
                while (i < --j && x == nums[j]) // avoid duplicate
                    ;
            }
            if (sum < target)
                i++;
            if (sum > target)
                j--;
        }
    }

    /**
     * 34. Search for a Range
     * <p>
     * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
     * Your algorithm’s runtime complexity must be in the order of O(log n).
     * If the target is not found in the array, return [-1, -1].
     * For example,
     * Given [5, 7, 7, 8, 8, 10] and target value 8,
     * return [3, 4].
     * <p>
     * https://leetcode.com/problems/search-for-a-range/#/description
     */
    public int[] searchRange1(int[] nums, int target) {
        int index1 = binarySearch1(nums, target, 0, nums.length - 1);
        int index2 = binarySearch2(nums, target, 0, nums.length - 1);
        return new int[]{index1, index2};
    }

    private int binarySearch1(int[] nums, int target, int low, int high) {
        if (low > high) return -1;
        if (low == high) return nums[low] == target ? low : -1;
        int mid = (high + low) / 2;
        if (nums[mid] >= target) {
            return binarySearch1(nums, target, low, mid);
        } else {
            return binarySearch1(nums, target, mid + 1, high);
        }
    }

    private int binarySearch2(int[] nums, int target, int low, int high) {
        if (low > high) return -1;
        if (low == high) return nums[low] == target ? low : -1;
        int mid = (high + low) / 2 + 1;
        if (nums[mid] <= target) {
            return binarySearch2(nums, target, mid, high);
        } else {
            return binarySearch2(nums, target, low, mid - 1);
        }
    }

    /**
     * 632. Smallest Range
     * You have k lists of sorted integers in ascending order.
     * Find the smallest range that includes at least one number from each of the k lists.
     * <p>
     * We define the range [a,b] is smaller than range [c,d] if b-a < d-c or a < c if b-a == d-c.
     * <p>
     * Example 1:
     * Input:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
     * Output: [20,24]
     * Explanation:
     * List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
     * List 2: [0, 9, 12, 20], 20 is in range [20,24].
     * List 3: [5, 18, 22, 30], 22 is in range [20,24].
     * Note:
     * The given list may contain duplicates, so ascending order means >= here.
     * 1 <= k <= 3500
     * -105 <= value of elements <= 105.
     * For Java users, please note that the input type has been changed to List<List<Integer>>.
     * And after you reset the code template, you’ll see this point.
     * <p>
     * https://leetcode.com/problems/smallest-range/#/description
     */

    public static int[] smallestRange(List<List<Integer>> nums) {
        class Element {
            private int row;
            private int idx;
            private int val;

            private Element(int r, int i, int v) {
                row = r;
                idx = i;
                val = v;
            }
        }
        PriorityQueue<Element> pq = new PriorityQueue<>(new Comparator<Element>() {
            public int compare(Element a, Element b) {
                return a.val - b.val;
            }
        });
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            Element e = new Element(i, 0, nums.get(i).get(0));
            pq.offer(e);
            max = Math.max(max, nums.get(i).get(0));
        }
        int range = Integer.MAX_VALUE;
        int start = -1, end = -1;
        while (pq.size() == nums.size()) {
            Element curr = pq.poll();
            if (max - curr.val < range) {
                range = max - curr.val;
                start = curr.val;
                end = max;
            }
            if (curr.idx + 1 < nums.get(curr.row).size()) {
                curr.idx = curr.idx + 1;
                curr.val = nums.get(curr.row).get(curr.idx);
                pq.offer(curr);
                if (curr.val > max) {
                    max = curr.val;
                }
            }
        }

        return new int[]{start, end};
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 0, 0, 0, 0, 1};
        System.out.println(fourSum(nums, 0));
    }
}
