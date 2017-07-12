package liye.carlos.myToolProcess.algorithm;

import java.util.*;

/**
 * Created by liye3 on 2017/7/3.
 */
public class Tree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 94. Binary Tree Inorder Traversal
     * <p>
     * Given a binary tree, return the inorder traversal of its nodes’ values.
     * <p>
     * For example:
     * Given binary tree [1,null,2,3],
     * 1
     * \
     * 2
     * /
     * 3
     * return [1,3,2].
     * <p>
     * Note: Recursive solution is trivial, could you do it iteratively?
     * <p>
     * https://leetcode.com/problems/binary-tree-inorder-traversal/#/description
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        inorderTraversalTree(result, root);

        return result;
    }

    private void inorderTraversalTree(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inorderTraversalTree(result, root.left);
        }
        result.add(root.val);
        if (root.right != null) {
            inorderTraversalTree(result, root.right);
        }
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.empty()) {
            while (root.left != null) {
                root = root.left;
                s.push(root);
            }
            root = s.pop();
            root.left = null;
            result.add(root.val);
            if (root.right != null) {

                root = root.right;
                s.push(root);
            }
        }
        return result;
    }

    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }

    /**
     * 226. Invert Binary Tree
     * <p>
     * Invert a binary tree.
     * <p>
     * ----- 4
     * --- /   \
     * -- 2     7
     * - / \   / \
     * 1   3 6   9
     * ----- to
     * ----- 4
     * --- /   \
     * -- 7     2
     * - / \   / \
     * 9   6 3   1
     * <p>
     * Trivia:
     * This problem was inspired by this original tweet by Max Howell:
     * Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so fuck off.
     * <p>
     * https://leetcode.com/problems/invert-binary-tree/#/description
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;
    }

    public TreeNode invertTreeWithoutRecursion(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.empty()) {
            TreeNode cur = s.pop();
            if (cur != null) {
                s.push(cur.left);
                s.push(cur.right);
                TreeNode tmp = cur.left;
                cur.left = cur.right;
                cur.right = tmp;
            }
        }
        return root;
    }


    /**
     * 508. Most Frequent Subtree Sum
     * <p>
     * Given the root of a tree, you are asked to find the most frequent subtree sum.
     * The subtree sum of a node is defined as the sum of all the node values
     * formed by the subtree rooted at that node (including the node itself).
     * So what is the most frequent subtree sum value?
     * If there is a tie, return all the values with the highest frequency in any order.
     * <p>
     * Examples 1
     * Input:
     * <p>
     * --- 5
     * - /  \
     * 2   -3
     * return [2, -3, 4], since all the values happen only once, return all of them in any order.
     * Examples 2
     * Input:
     * <p>
     * --- 5
     * - /  \
     * 2   -5
     * return [2], since 2 happens twice, however -5 only occur once.
     * Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
     * <p>
     * https://leetcode.com/problems/most-frequent-subtree-sum/#/description
     */
    private Map<Integer, Integer> sumToCount;
    private int maxCount;

    public int[] findFrequentTreeSum(TreeNode root) {
        maxCount = 0;
        sumToCount = new HashMap<Integer, Integer>();
        postOrder(root);
        List<Integer> res = new ArrayList<>();
        for (int key : sumToCount.keySet()) {
            if (sumToCount.get(key) == maxCount) {
                res.add(key);
            }
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    private int postOrder(TreeNode root) {
        if (root == null) return 0;

        int left = postOrder(root.left);
        int right = postOrder(root.right);

        int sum = left + right + root.val;
        int count = sumToCount.getOrDefault(sum, 0) + 1;
        sumToCount.put(sum, count);
        maxCount = Math.max(maxCount, count);
        return sum;
    }

}
