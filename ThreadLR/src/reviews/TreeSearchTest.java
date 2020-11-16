package reviews;

import algorithm.binarysearch.TreeNode;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/9/11 18:24
 * [description]:
 */
public class TreeSearchTest {

    public static void main(String[] args) {
        String[] nodeVal = new String[]{"1", "2", "2", "3", "009", "4", "3"};
        TreeNode<String> root = levelBuildST(nodeVal);
        System.out.println(root);
        System.out.println(preOrderVisit(root));
        System.out.println(inOrderVisit(root));
        System.out.println(postOrderVisit(root));
        System.out.println(levelVisit(root));
        System.out.println(isSymmetric(root));
        System.out.println(isSymmetricLevel(root));
        System.out.println(maxDepth(root));
    }

    // 层次建立二叉树
    public static TreeNode<String> levelBuildST(String[] vals) {
        if (vals == null || vals.length <= 0) {
            return null;
        }
        TreeNode<String> root = new TreeNode<>(vals[0]);
        TreeNode<String> p = root;
        Queue<TreeNode<String>> queue = new LinkedList<>();

        int i = 0;
        while (p != null) {
            if (i * 2 + 1 < vals.length) {
                if (vals[i * 2 + 1] != null) {
                    p.left = new TreeNode<>(vals[i * 2 + 1]);
                    queue.add(p.left);
                }
            }
            if (i * 2 + 2 < vals.length) {
                if (vals[i * 2 + 2] != null) {
                    p.right = new TreeNode<>(vals[i * 2 + 2]);
                    queue.add(p.right);
                }
            }
            i += 1;
            p = queue.poll();
        }
        return root;
    }

    // 前序遍历
    public static List<String> preOrderVisit(TreeNode<String> node) {
        List<String> res = new ArrayList<>();
        if (node == null) {
            return res;
        }

        res.add(node.val);
        res.addAll(preOrderVisit(node.left));
        res.addAll(preOrderVisit(node.right));
        return res;
    }

    // 中序遍历
    public static List<String> inOrderVisit(TreeNode<String> node) {
        List<String> res = new ArrayList<>();
        if (node == null) {
            return res;
        }

        res.addAll(inOrderVisit(node.left));
        res.add(node.val);
        res.addAll(inOrderVisit(node.right));
        return res;
    }

    // 后序遍历
    public static List<String> postOrderVisit(TreeNode<String> node) {
        List<String> res = new ArrayList<>();
        if (node == null) {
            return res;
        }

        res.addAll(postOrderVisit(node.left));
        res.addAll(postOrderVisit(node.right));
        res.add(node.val);
        return res;
    }

    // 层序遍历
    public static List<List<String>> levelVisit(TreeNode<String> node) {
        List<List<String>> res = new ArrayList<>();
        if (node == null) {
            return res;
        }
        Queue<TreeNode<String>> levelQueue = new LinkedList<>();
        levelQueue.add(node);

        while (!levelQueue.isEmpty()) {
            List<String> levelRes = new ArrayList<>();
            int levelCount = levelQueue.size();
            for (int i = 0; i < levelCount; i++) {
                TreeNode<String> p = levelQueue.poll();
                if (p != null) {
                    levelRes.add(p.val);
                    if (p.left != null) {
                        levelQueue.add(p.left);
                    }
                    if (p.right != null) {
                        levelQueue.add(p.right);
                    }
                }
            }
            res.add(levelRes);
        }

        return res;
    }

    // 递归方式实现镜像判断
    public static boolean isSymmetric(TreeNode<String> root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public static boolean isSymmetric(TreeNode<String> left, TreeNode<String> right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (!left.val.equals(right.val))
            return false;
        if (!isSymmetric(left.left, right.right))
            return false;
        if (!isSymmetric(left.right, right.left))
            return false;
        return true;
    }

    // 队列方式实现镜像判断
    public static boolean isSymmetricLevel(TreeNode<String> root) {
        return false;
    }

    // 最大深度
    public static int maxDepth(TreeNode root) {
        return 0;
    }
}
