package liye.carlos.myToolProcess.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

}
