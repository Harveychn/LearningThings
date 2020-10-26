package ptOffer;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/10/24 10:36
 * [description]: 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 */
public class Offer55 {
    public static void main(String[] args) {


    }

    // 后序遍历 + 判断深度 实现
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(treeDepth(root.left) - treeDepth(root.right)) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    public int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
    }


    public boolean isBalanced3(TreeNode root) {
        return recur2(root) != -1;
    }

    // 后续遍历 + 剪枝 实现
    private int recur2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = recur2(root.left);
        if (left == -1) {
            return -1;
        }
        int right = recur2(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

    // 后续遍历 + 判断深度
    public boolean isBalanced2(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced2(root.left) && isBalanced2(root.right);
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
