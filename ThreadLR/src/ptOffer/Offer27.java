package ptOffer;

import sun.reflect.generics.tree.Tree;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/10/20 21:22
 * [description]: 请完成一个函数，输入一个二叉树，该函数输出它的镜像
 */
public class Offer27 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = null;

        Offer27 offer27 = new Offer27();
        TreeNode res = offer27.mirrorTree(treeNode);
        System.out.println(res);
    }
// FIXME can you？

//    public TreeNode mirrorTree(TreeNode root) {
//        if (root == null) {
//            return root;
//        }
//        change(root, root.left, root.right);
//        return root;
//    }

//    private void change(TreeNode parent, TreeNode left, TreeNode right) {
//        if (left == null && right == null) {
//            return;
//        }
//        if (left == null) {
//            parent.left = parent.right;
//            parent.right = null;
//            return;
//        }
//        if (right == null) {
//            parent.right = parent.left;
//            parent.left = null;
//            return;
//        }
//        if (left != null && right != null) {
//            int temp = left.val;
//            left.val = right.val;
//            right.val = temp;
//        }
//        change(left.left, right.right);
//        change(left.right, right.left);
//
//    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
