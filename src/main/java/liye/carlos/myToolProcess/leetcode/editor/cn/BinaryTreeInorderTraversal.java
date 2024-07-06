//给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 2099 👎 0


package liye.carlos.myToolProcess.leetcode.editor.cn;

import liye.carlos.myToolProcess.dto.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {


        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            Stack<TreeNode> stn = new Stack<>();
            TreeNode cNode = root;
            while (!stn.isEmpty() || cNode != null) {
                if (cNode != null) {
                    stn.push(cNode);
                    cNode = cNode.left;
                } else {
                    TreeNode tmp = stn.pop();
                    result.add(tmp.val);
                    cNode = tmp.right;
                }
            }


            return result;
        }


        //        public List<Integer> inorderTraversal(TreeNode root) {
//            List<Integer> result = new ArrayList<>();
//            inorder(root, result);
//            return result;
//        }
//
        private void inorder(TreeNode node, List<Integer> result) {
            if (node == null) {
                return;
            }
            inorder(node.left, result);
            result.add(node.val);
            inorder(node.right, result);
        }

        private void preOrder(TreeNode node, List<Integer> result) {
            if (node == null) {
                return;
            }
            result.add(node.val);
            inorder(node.left, result);
            inorder(node.right, result);
        }


        private void afterOrder(TreeNode node, List<Integer> result) {
            if (node == null) {
                return;
            }
            inorder(node.left, result);
            inorder(node.right, result);
            result.add(node.val);
        }

        public List<Integer> preorderStack(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            Stack<TreeNode> stn = new Stack<>();
            stn.push(root);
            while (!stn.isEmpty()) {
                TreeNode cur = stn.pop();
                result.add(cur.val);
                if (cur.right != null) {
                    stn.push(cur.right);
                }
                if (cur.left != null) {
                    stn.push(cur.left);
                }
            }

            return result;
        }

        public List<Integer> postorderStack(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            Stack<TreeNode> stn = new Stack<>();
            TreeNode lastNode = null;
            stn.push(root);
            while (!stn.isEmpty()) {
                TreeNode tmp = stn.peek();
                if (tmp.left != null && lastNode != tmp.left && lastNode != tmp.right) {
                    stn.push(tmp.left);
                } else if (tmp.right != null && lastNode != tmp.right) {
                    stn.push(tmp.right);
                } else {
                    result.add(tmp.val);
                    stn.pop();
                    lastNode = tmp;
                }

            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}