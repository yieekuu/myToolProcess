package liye.carlos.myToolProcess.algorithm;

import java.util.*;

/**
 * Created by liye3 on 2017/7/4.
 */

public class BinaryTree {
    private BinaryTree lchild;
    private BinaryTree rchild;
    private Object data;

    public BinaryTree(BinaryTree l, BinaryTree r, Object data) {
        lchild = l;
        rchild = r;
        this.data = data;
    }

    public static void main(String[] args) {
        BinaryTree G = new BinaryTree(null, null, 'G');
        BinaryTree H = new BinaryTree(null, null, 'H');
        BinaryTree F = new BinaryTree(G, H, 'F');
        BinaryTree D = new BinaryTree(null, F, 'D');
        BinaryTree E = new BinaryTree(null, null, 'E');
        BinaryTree B = new BinaryTree(D, E, 'B');
        BinaryTree C = new BinaryTree(null, null, 'C');
        BinaryTree A = new BinaryTree(B, C, 'A');

        System.out.println("先序遍历。。。。。。。");
        pre(A);
        System.out.println();

        System.out.println("中序遍历。。。。。。。");
        in(A);
        System.out.println();

        System.out.println("后序遍历。。。。。。。");
        post(A);
        System.out.println();

        System.out.println("非递归先序遍历。。。。。。。");
        preTraverse(A);
        System.out.println();

        System.out.println("非递归中序遍历。。。。。。。");
        inTraverse(A);
        System.out.println();

        System.out.println("非递归后序遍历。。。。。。。");
        postTraverse(A);
        System.out.println();

        System.out.println("非递归后序遍历2。。。。。。。");
        postTraverse2(A);
        System.out.println();

    }

    private static void visit(BinaryTree bt) {
        System.out.print(bt.data + " ");
    }

    //递归先序遍历
    public static void pre(BinaryTree root) {
        if (root == null) return;
        visit(root);
        if (root.lchild != null) pre(root.lchild);
        if (root.rchild != null) pre(root.rchild);
    }

    //递归中序遍历
    public static void in(BinaryTree root) {
        if (root == null) return;
        if (root.lchild != null) in(root.lchild);
        visit(root);
        if (root.rchild != null) in(root.rchild);
    }

    //递归后序遍历
    public static void post(BinaryTree root) {
        if (root == null) return;
        if (root.lchild != null) post(root.lchild);
        if (root.rchild != null) post(root.rchild);
        visit(root);
    }

    //非递归先序遍历
    public static void preTraverse(BinaryTree root) {
        Stack<BinaryTree> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            BinaryTree cur = s.pop();
            visit(cur);
            if (cur.lchild != null) s.push(cur.lchild);
            if (cur.rchild != null) s.push(cur.rchild);
        }
    }

    //非递归中序遍历
    public static void inTraverse(BinaryTree root) {
        Stack<BinaryTree> s = new Stack<>();
        BinaryTree cur = root;
        while (cur != null || !s.isEmpty()) {
            while (cur != null) {
                s.push(cur);
                cur = cur.lchild;
            }
            cur = s.pop();
            visit(cur);
            cur = cur.rchild;
        }
    }

    public static void postTraverse(BinaryTree root) {
        Stack<BinaryTree> s1 = new Stack<>();
        Stack<BinaryTree> s2 = new Stack<>();
        BinaryTree cur = root;
        s1.push(cur);
        while (!s1.empty()) {
            cur = s1.pop();
            s2.push(cur);
            if (cur.lchild != null) {
                s1.push(cur.lchild);
            }
            if (cur.rchild != null) {
                s1.push(cur.rchild);
            }
        }
        while (!s2.empty()) {
            visit(s2.peek());
            s2.pop();
        }
    }

    public static void postTraverse2(BinaryTree root) {
        Stack<BinaryTree> s = new Stack<>();
        BinaryTree cur = root;
        BinaryTree pre = null;
        while (cur != null || !s.empty()) {
            while (cur != null) {
                s.push(cur);
                cur = cur.lchild;

            }
            cur = s.peek();
            if (cur.rchild == null || cur.rchild == pre) {
                visit(cur);
                pre = cur;
                s.pop();
                cur = null;
            } else {
                cur = cur.rchild;
            }
        }
    }
}
