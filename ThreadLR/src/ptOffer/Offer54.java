package ptOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/10/24 10:06
 * [description]: 给定一棵二叉搜索树，请找出其中第k大的节点。
 */
public class Offer54 {
    public static void main(String[] args) {

    }

    public int kthLargest(TreeNode root, int k) {
        List<Integer> travelList = new ArrayList<>();
        inOrderTravel(travelList, root);
        return travelList.get(travelList.size() - 1 - k);
    }

    public void inOrderTravel(List<Integer> travel, TreeNode p) {
        if (p == null) {
            return;
        }
        inOrderTravel(travel, p.left);
        travel.add(p.val);
        inOrderTravel(travel, p.right);
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
