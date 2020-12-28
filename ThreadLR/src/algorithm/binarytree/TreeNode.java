package algorithm.binarytree;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/8/24 16:54
 * [description]:
 */
public class TreeNode<T> {
    public T val;
    public TreeNode<T> left;
    public TreeNode<T> right;

    TreeNode() {
    }

    public TreeNode(T val) {
        this.val = val;
    }

    TreeNode(T val, TreeNode<T> left, TreeNode<T> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
