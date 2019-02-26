package liye.carlos.myToolProcess.algorithm;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by liye3 on 2017/7/7.
 */
public class ArrayALG {

    /**
     * 81. Search in Rotated Sorted ArrayALG II
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
     * 532. K-diff Pairs in an ArrayALG
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

    /**
     * 417. Pacific Atlantic Water Flow
     * <p>
     * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent,
     * the “Pacific ocean” touches the left and top edges of the matrix and
     * the “Atlantic ocean” touches the right and bottom edges.
     * <p>
     * Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
     * <p>
     * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
     * <p>
     * Note:
     * The order of returned grid coordinates does not matter.
     * Both m and n are less than 150.
     * Example:
     * <p>
     * Given the following 5x5 matrix:
     * <p>
     * Pacific ~   ~   ~   ~   ~
     * ~  1   2   2   3  (5) *
     * ~  3   2   3  (4) (4) *
     * ~  2   4  (5)  3   1  *
     * ~ (6) (7)  1   4   5  *
     * ~ (5)  1   1   2   4  *
     * *   *   *   * Atlantic
     * <p>
     * Return:
     * <p>
     * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
     * <p>
     * https://leetcode.com/problems/pacific-atlantic-water-flow/#/description
     */
    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<int[]> pacificAtlantic1(int[][] matrix) {
        List<int[]> res = new LinkedList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int n = matrix.length, m = matrix[0].length;
        //One visited map for each ocean
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();
        for (int i = 0; i < n; i++) { //Vertical border
            pQueue.offer(new int[]{i, 0});
            aQueue.offer(new int[]{i, m - 1});
            pacific[i][0] = true;
            atlantic[i][m - 1] = true;
        }
        for (int i = 0; i < m; i++) { //Horizontal border
            pQueue.offer(new int[]{0, i});
            aQueue.offer(new int[]{n - 1, i});
            pacific[0][i] = true;
            atlantic[n - 1][i] = true;
        }
        bfs(matrix, pQueue, pacific);
        bfs(matrix, aQueue, atlantic);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j])
                    res.add(new int[]{i, j});
            }
        }
        return res;
    }

    public void bfs(int[][] matrix, Queue<int[]> queue, boolean[][] visited) {
        int n = matrix.length, m = matrix[0].length;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] d : dir) {
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];
                if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || matrix[x][y] < matrix[cur[0]][cur[1]]) {
                    continue;
                }
                visited[x][y] = true;
                queue.offer(new int[]{x, y});
            }
        }
    }

    public List<int[]> pacificAtlantic2(int[][] matrix) {
        List<int[]> res = new LinkedList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int n = matrix.length, m = matrix[0].length;
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
            dfs(matrix, atlantic, Integer.MIN_VALUE, i, m - 1);
        }
        for (int i = 0; i < m; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
            dfs(matrix, atlantic, Integer.MIN_VALUE, n - 1, i);
        }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (pacific[i][j] && atlantic[i][j])
                    res.add(new int[]{i, j});
        return res;
    }

    public void dfs(int[][] matrix, boolean[][] visited, int height, int x, int y) {
        int n = matrix.length, m = matrix[0].length;
        if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || matrix[x][y] < height)
            return;
        visited[x][y] = true;
        for (int[] d : dir) {
            dfs(matrix, visited, matrix[x][y], x + d[0], y + d[1]);
        }
    }

    /**
     * 52. N-Queens II
     * <p>
     * Follow up for N-Queens problem.
     * <p>
     * Now, instead outputting board configurations, return the total number of distinct solutions.
     * <p>
     * https://leetcode.com/problems/n-queens-ii/#/description
     */
    private int count = 0;

    public int totalNQueens(int n) {
        if (n < 1) return 0;
        boolean[] cols = new boolean[n];     // columns   |
        boolean[] d1 = new boolean[2 * n];   // diagonals \
        boolean[] d2 = new boolean[2 * n];   // diagonals /
        backtracking(0, cols, d1, d2, n);
        return count;
    }

    public void backtracking(int row, boolean[] cols, boolean[] d1, boolean[] d2, int n) {
        if (row == n) count++;

        for (int col = 0; col < n; col++) {
            int id1 = col - row + n;
            int id2 = col + row;
            if (cols[col] || d1[id1] || d2[id2]) continue;

            cols[col] = true;
            d1[id1] = true;
            d2[id2] = true;
            backtracking(row + 1, cols, d1, d2, n);
            cols[col] = false;
            d1[id1] = false;
            d2[id2] = false;
        }
    }

    /**
     * 611. Valid Triangle Number
     * <p>
     * Given an array consists of non-negative integers,
     * your task is to count the number of triplets chosen from the array that
     * can make triangles if we take them as side lengths of a triangle.
     * <p>
     * Example 1:
     * Input: [2,2,3,4]
     * Output: 3
     * Explanation:
     * Valid combinations are:
     * 2,3,4 (using the first 2)
     * 2,3,4 (using the second 2)
     * 2,2,3
     * Note:
     * The length of the given array won’t exceed 1000.
     * The integers in the given array are in the range of [0, 1000].
     * <p>
     * https://leetcode.com/problems/valid-triangle-number/#/description
     */
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int m = j + 1; m < nums.length; m++) {
                    if (nums[i] + nums[j] <= nums[m]) {
                        break;
                    }
                    result++;
                }
            }
        }
        return result;
    }

    public int triangleNumber1(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int result = 0;
        Arrays.sort(nums);
        for (int i = nums.length - 1; i > 0; i--) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    result += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }


    private int binarySearchForTriangleNumber(int nums[], int l, int r, int x) {
        while (r >= l && r < nums.length) {
            int mid = (l + r) / 2;
            if (nums[mid] >= x)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }

    public int triangleNumber2(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int k = i + 2;
            for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
                k = binarySearchForTriangleNumber(nums, k, nums.length - 1, nums[i] + nums[j]);
                result += k - j - 1;
            }
        }
        return result;
    }

    /**
     * 566. Reshape the Matrix
     * <p>
     * In MATLAB, there is a very useful function called ‘reshape’,
     * which can reshape a matrix into a new one with different size but keep its original data.
     * <p>
     * You’re given a matrix represented by a two-dimensional array,
     * and two positive integers r and c representing the row number and
     * column number of the wanted reshaped matrix, respectively.
     * <p>
     * The reshaped matrix need to be filled with all the elements of the original matrix
     * in the same row-traversing order as they were.
     * <p>
     * If the ‘reshape’ operation with given parameters is possible and legal,
     * output the new reshaped matrix; Otherwise, output the original matrix.
     * <p>
     * Example 1:
     * Input:
     * nums =
     * [[1,2],
     * [3,4]]
     * r = 1, c = 4
     * Output:
     * [[1,2,3,4]]
     * Explanation:
     * The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix,
     * fill it row by row by using the previous list.
     * Example 2:
     * Input:
     * nums =
     * [[1,2],
     * [3,4]]
     * r = 2, c = 4
     * Output:
     * [[1,2],
     * [3,4]]
     * Explanation:
     * There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.
     * Note:
     * The height and width of the given matrix is in range [1, 100].
     * The given r and c are all positive.
     * <p>
     * https://leetcode.com/problems/reshape-the-matrix/#/description
     */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        if (r * c != m * n) {
            return nums;
        }
        int[][] result = new int[r][c];
        for (int i = 0; i < r * c; i++) {
            result[i / c][i % c] = nums[i / n][i % n];
        }
        return result;
    }

    /**
     * 697. Degree of an Array
     * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
     * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
     * Example 1:
     * Input: [1, 2, 2, 3, 1]
     * Output: 2
     * Explanation:
     * The input array has a degree of 2 because both elements 1 and 2 appear twice.
     * Of the subarrays that have the same degree:
     * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
     * The shortest length is 2. So return 2.
     * 提示：提交代码后，需要用简洁的语言解释一下代码思路~ 谢谢
     * 历史题目和总结见公众号「每日一道算法题」
     * https://leetcode.com/problems/degree-of-an-array/description/
     */
    public int findShortestSubArray(int[] nums) {
        if (null == nums || nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        HashMap<Integer, Integer> countMap = new HashMap<>();
        HashMap<Integer, Integer> leftMap = new HashMap<>();
        HashMap<Integer, Integer> rightMap = new HashMap<>();
        int size = nums.length;

        for (int i = 0; i < size; i++) {
            if (!countMap.containsKey(nums[i])) {
                countMap.put(nums[i], 0);
                leftMap.put(nums[i], i);
            }
            countMap.put(nums[i], countMap.get(nums[i]) + 1);
            rightMap.put(nums[i], i);
        }
        int degree = Collections.max(countMap.values());
        Integer result = size;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == degree) {
                int tmp = rightMap.get(entry.getKey()) - leftMap.get(entry.getKey()) + 1;
                result = Math.min(tmp, result);
            }
        }

        return result;
    }

    /**
     * 442. Find All Duplicates in an Array
     * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
     * Find all the elements that appear twice in this array.
     * Could you do it without extra space and in O(n) runtime?
     * Example:
     * Input:
     * [4,3,2,7,8,2,3,1]
     * Output:
     * [2,3]
     * 提示：提交代码后，需要用简洁的语言解释一下代码思路~ 谢谢
     * 历史题目和总结见公众号「每日一道算法题」
     * https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                result.add(Math.abs(nums[i]));
            }
            nums[index] = -nums[index];
        }

        return result;
    }

    /**
     * 390. Elimination Game
     * There is a list of sorted integers from 1 to n. Starting from left to right, remove the first number and every other number afterward until you reach the end of the list.
     * Repeat the previous step again, but this time from right to left, remove the right most number and every other number from the remaining numbers.
     * We keep repeating the steps again, alternating left to right and right to left, until a single number remains.
     * Find the last number that remains starting with a list of length n.
     * Example:
     * Input:
     * n = 9,
     * 1 2 3 4 5 6 7 8 9
     * 2 4 6 8
     * 2 6
     * 6
     * Output:
     * 6
     * 提示：提交代码后，需要用简洁的语言解释一下代码思路~ 谢谢
     * 历史题目和总结见公众号「每日一道算法题」
     * https://leetcode.com/problems/elimination-game/description/
     */
    public int lastRemaining(int n) {
        boolean left = true;
        int remaining = n;
        int step = 1;
        int head = 1;
        while (remaining > 1) {
            if (left || remaining % 2 == 1) {
                head = head + step;
            }
            remaining = remaining / 2;
            step = step * 2;
            left = !left;
        }
        return head;
    }

    /*
    229. Majority Element II
    Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
    提示：提交代码后，需要用简洁的语言解释一下代码思路~ 谢谢
    历史题目和总结见公众号「每日一道算法题」
    https://leetcode.com/problems/majority-element-ii/description/
    */
    /*
    思路：摩尔投票升级版，超过n/3的数最多只能有两个；
    先选出两个候选人A,B,遍历数组，如果投A（等于A），则A的票数++;如果投B，B的票数++；
    如果A,B都不投（即与A，B都不相等）,那么检查此时是否AB中候选人的票数是否为0，如果为0,则成为新的候选人；
    如果A,B两个人的票数都不为0，那么A,B两个候选人的票数均--；
    遍历结束后选出两个候选人，但是这两个候选人是否满足>n/3，还需要再遍历一遍数组，找出两个候选人的具体票数
     */
    public List<Integer> majorityElement1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        //初始化，定义两个候选人以及对应的票数
        int candidateA = nums[0];
        int candidateB = nums[0];
        int countA = 0;
        int countB = 0;

        // 遍历数组
        for (int num : nums) {
            if (num == candidateA) { //投A
                countA++;
                continue;
            }

            if (num == candidateB) {// 投B
                countB++;
                continue;
            }
            //此时A,B都不投,检查是否有票数为0情况，如果为0，则更新候选人
            if (countA == 0) {
                candidateA = num;
                countA++;
                continue;
            }

            if (countB == 0) {
                candidateB = num;
                countB++;
                continue;
            }

            //此时两个候选人的票数都大于1，且当前选名不投AB，那么A,B对应的票数都要--;
            countA--;
            countB--;
        }

        // 上一轮遍历找出了两个候选人，但是这两个候选人是否均满足票数大于N/3仍然没法确定，需要重新遍历，确定票数
        countA = 0;
        countB = 0;

        for (int num : nums) {
            if (num == candidateA) {
                countA++;
            } else if (num == candidateB) {
                countB++;
            }
        }

        List<Integer> resultList = new ArrayList<>();

        if (countA > nums.length / 3) {
            resultList.add(candidateA);
        }

        if (countB > nums.length / 3) {
            resultList.add(candidateB);
        }

        return resultList;
    }

    public static List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        int candidate1 = 0;
        int candidate2 = 1;
        int count1 = 0;
        int count2 = 0;
        for (int n : nums) {
            if (candidate1 == n) {
                count1++;
            } else if (candidate2 == n) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = n;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = n;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        List<Integer> result = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for (int n : nums) {
            if (candidate1 == n) count1++;
            else if (candidate2 == n) count2++;
        }
        if (count1 > nums.length / 3) result.add(candidate1);
        if (count2 > nums.length / 3) result.add(candidate2);
        return result;
    }

    /*
    334. Increasing Triplet Subsequence
    Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
    Formally the function should:
    Return true if there exists i, j, k
    such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
    Your algorithm should run in O(n) time complexity and O(1) space complexity.
    Examples:
    Given [1, 2, 3, 4, 5],
            return true.
    Given [5, 4, 3, 2, 1],
            return false.
    提示：提交代码后，需要用简洁的语言解释一下代码思路~ 谢谢
    历史题目和总结见公众号「每日一道算法题」
    https://leetcode.com/problems/increasing-triplet-subsequence/description/
    */
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int small = Integer.MAX_VALUE;
        int big = Integer.MAX_VALUE;
        for (int n : nums) {
            if (small >= n) {
                small = n;
            } else if (big >= n) {
                big = n;
            } else {
                return true;
            }
        }
        return false;
    }

    /*
    473. Matchsticks to Square
    Remember the story of Little Match Girl? By now, you know exactly what matchsticks the little match girl has, please find out a way you can make one square by using up all those matchsticks. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.
    Your input will be several matchsticks the girl has, represented with their stick length. Your output will either be true or false, to represent whether you could make one square using all the matchsticks the little match girl has.
            Example 1:
    Input: [1,1,2,2,2]
    Output: true
    Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
    Example 2:
    Input: [3,3,3,3,4]
    Output: false
    Explanation: You cannot find a way to form a square with all the matchsticks.
            Note:
    The length sum of the given matchsticks is in the range of 0 to 10^9.
    The length of the given matchstick array will not exceed 15.
    提示：提交代码后，需要用简洁的语言解释一下代码思路~ 谢谢
    历史题目和总结见公众号「每日一道算法题」
    https://leetcode.com/problems/matchsticks-to-square/description/
    */
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4) return false;
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 4 != 0) return false;

        Arrays.sort(nums);
        reverse(nums);

        return dfs(nums, new int[4], 0, sum / 4);
    }

    private boolean dfs(int[] nums, int[] sums, int index, int target) {
        if (index == nums.length) {
            if (sums[0] == target && sums[1] == target && sums[2] == target) {
                return true;
            }
            return false;
        }

        for (int i = 0; i < 4; i++) {
            if (sums[i] + nums[index] > target) continue;
            sums[i] += nums[index];
            if (dfs(nums, sums, index + 1, target)) return true;
            sums[i] -= nums[index];
        }

        return false;
    }

    private void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    /*
    457. Circular Array Loop
    You are given an array of positive and negative integers. If a number n at an index is positive, then move forward n steps. Conversely, if it’s negative (-n), move backward n steps. Assume the first element of the array is forward next to the last element, and the last element is backward next to the first element. Determine if there is a loop in this array. A loop starts and ends at a particular index with more than 1 element along the loop. The loop must be “forward” or “backward’.
    Example 1: Given the array [2, -1, 1, 2, 2], there is a loop, from index 0 -> 2 -> 3 -> 0.
    Example 2: Given the array [-1, 2], there is no loop.
    Note: The given array is guaranteed to contain no element “0”.
    Can you do it in O(n) time complexity and O(1) space complexity?
    提示：提交代码后，需要用简洁的语言解释一下代码思路~ 谢谢
    历史题目和总结见公众号「每日一道算法题」
    https://leetcode.com/problems/circular-array-loop/description/
    */
    public static boolean circularArrayLoop(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            int j = i;
            j =  Math.abs((nums[j] + nums.length + j) % nums.length);
            int last = 0;
            while (j > i) {
                last = j;
                j = Math.abs((nums[j] + nums.length + j) % nums.length);
                count++;
                if (j == nums[j] || count > nums.length - 1) {
                    break;
                }
            }
            if (count > 1 && j == i && nums[last] + last >= nums.length) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,2};

        System.out.println(circularArrayLoop(nums));
    }


}

































