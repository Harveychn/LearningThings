package algorithm.binarysearch;

import java.util.*;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/8/24 16:56
 * [description]:
 */
public class Solution {
    public static void main(String[] args) {
//        String[] vals = new String[]{"3", "9", "20", null, null, "15", "7"};
//        String[] vals = new String[]{"1", "2", "2", "3", "4", "6", "3"};
//        String[] vals = new String[]{"1", "2", "2", null, "3", null, "3"};
        String[] vals = new String[]{"1", "2", "3", "4", "5", "6", "7", null, null, null, null, "8", "9", null, null};
        TreeNode<String> root = levelBuildST(vals);
        System.out.println(root);
        System.out.println(preOrderTravel(root));
        System.out.println(preOrderTravelStack(root));
        System.out.println("前序遍历结束\n");
        System.out.println(inorderTraversal(root));
        System.out.println(inorderTravelStack(root));
        System.out.println("中序遍历结束\n");
        System.out.println(postorderTraversal(root));
        System.out.println("后序遍历结束\n");
        System.out.println(levelOrder(root));
        System.out.println("层序遍历结束\n");
        System.out.println(isSymmetricCascade(root));
        System.out.println(isSymmetric(root));
    }

    // 层次建立二叉树
    public static TreeNode<String> levelBuildST(String[] vals) {
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
            p = queue.poll();
            i++;
        }
        return root;
    }

    // 前序遍历
    public static List<String> preOrderTravel(TreeNode<String> root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.add(root.val);
        if (root.left != null) {
            result.addAll(preOrderTravel(root.left));
        }
        if (root.right != null) {
            result.addAll(preOrderTravel(root.right));
        }
        return result;
    }

    // 前序遍历 - 非递归实现
    public static List<String> preOrderTravelStack(TreeNode<String> root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode<String>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode<String> node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
    }

    // 中序遍历
    public static List<String> inorderTraversal(TreeNode<String> root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        if (root.left != null) {
            result.addAll(inorderTraversal(root.left));
        }
        result.add(root.val);
        if (root.right != null) {
            result.addAll(inorderTraversal(root.right));
        }
        return result;
    }

    // 中序遍历 - 非递归实现
    public static List<String> inorderTravelStack(TreeNode<String> root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode<String>> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode<String> node = stack.pop();
            res.add(node.val);
            root = node.right;
        }

        return res;
    }

    // 后序遍历
    public static List<String> postorderTraversal(TreeNode<String> root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        if (root.left != null) {
            result.addAll(postorderTraversal(root.left));
        }
        if (root.right != null) {
            result.addAll(postorderTraversal(root.right));
        }
        result.add(root.val);
        return result;
    }

    // 后续遍历 非递归实现
    public static List<String> postOrderTraverStack(TreeNode<String> root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }


        return res;
    }

    // 层序遍历
    public static List<List<String>> levelOrder(TreeNode<String> p) {
        List<List<String>> result = new ArrayList<>();
        if (p == null) {
            return result;
        }
        Queue<TreeNode<String>> queue = new LinkedList<>();
        queue.add(p);
        while (!queue.isEmpty()) {
            int levelCount = queue.size();
            List<String> levelVal = new ArrayList<>();
            for (int i = 0; i < levelCount; i++) {
                TreeNode<String> node = queue.poll();
                levelVal.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(levelVal);
        }
        return result;
    }

    // 是否对称二叉树 递归实现
    public static boolean isSymmetricCascade(TreeNode<String> root) {
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
        if (!left.val.equals(right.val)) {
            return false;
        }
        if (!isSymmetric(left.left, right.right)) {
            return false;
        }
        if (!isSymmetric(left.right, right.left)) {
            return false;
        }
        return true;
    }

    // 队列方式实现 是否对称二叉树
    public static boolean isSymmetric(TreeNode<String> root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        //用队列保存节点
        LinkedList<TreeNode<String>> queue = new LinkedList<>();
        //将根节点的左右孩子放到队列中
        queue.add(root.left);
        queue.add(root.right);
        while (queue.size() > 0) {
            //从队列中取出两个节点，再比较这两个节点
            TreeNode<String> left = queue.removeFirst();
            TreeNode<String> right = queue.removeFirst();
            //如果两个节点都为空就继续循环，两者有一个为空就返回false
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (!left.val.equals(right.val)) {
                return false;
            }
            //将左节点的左孩子， 右节点的右孩子放入队列
            queue.add(left.left);
            queue.add(right.right);
            //将左节点的右孩子，右节点的左孩子放入队列
            queue.add(left.right);
            queue.add(right.left);
        }

        return true;
    }
}
