package leetcode;

import java.util.*;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/9/24 9:11
 * [description]:
 */
public class LeetCode501 {
    public static void main(String[] args) {
        //TODO 需要优化效率
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private Map<Integer, Integer> itemCount = new TreeMap<>();


    public int[] findMode(TreeNode root) {
        treeTravel(root);
        final int[] max = {0};
        Set<Integer> res = new HashSet<>();

        itemCount.forEach((k, v) -> {
            if (max[0] < v) {
                max[0] = v;
                res.clear();
                res.add(k);
            } else if (max[0] == v) {
                res.add(k);
            } else {

            }
        });

        int[] rtnRes = new int[res.size()];
        int i = 0;
        for (Integer re : res) {
            rtnRes[i] = re;
            i++;
        }
        return rtnRes;
    }

    private void treeTravel(TreeNode p) {
        if (p == null) {
            return;
        }
        itemCount.put(p.val, itemCount.getOrDefault(p.val, 0) + 1);
        treeTravel(p.left);
        treeTravel(p.right);
    }
}
