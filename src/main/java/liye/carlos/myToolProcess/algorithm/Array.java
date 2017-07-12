package liye.carlos.myToolProcess.algorithm;

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



}
