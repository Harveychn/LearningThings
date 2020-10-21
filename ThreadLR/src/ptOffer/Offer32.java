package ptOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/10/21 17:07
 * [description]: 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行
 */
public class Offer32 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> link = new LinkedList<>();

        link.add(root);
        while (!link.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int levelCount = link.size();
            for (int i = 0; i < levelCount; i++) {
                TreeNode node = link.removeFirst();
                level.add(node.val);
                if (node.left != null) {
                    link.add(node.left);
                }
                if (node.right != null) {
                    link.add(node.right);
                }

            }
            res.add(level);
        }
        return res;
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
