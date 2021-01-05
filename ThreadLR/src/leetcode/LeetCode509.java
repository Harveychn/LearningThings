package leetcode;

/**
 * author: zhengxiaohui
 * create time: 2021/1/4 14:59
 * description:
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。
 */
public class LeetCode509 {

    public static void main(String[] args) {
        LeetCode509 leetCode509 = new LeetCode509();
        System.out.println(leetCode509.fib(3));
        System.out.println(leetCode509.fibQuick(3));
    }

    //    递归方式实现
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    // 线性方式实现
    public int fibQuick(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int[] table = new int[n + 1];
        table[0] = 0;
        table[1] = 1;
        for (int i = 2; i <= n; i++) {
            table[i] = table[i - 2] + table[i - 1];
        }
        return table[n];
    }
}
