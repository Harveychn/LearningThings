package leetcode;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/9/24 8:53
 * [description]:
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
public class LeetCode66 {
    public static void main(String[] args) {
        LeetCode66 leetCode66 = new LeetCode66();
        int[] digit = new int[]{1, 2, 3};
        for (int i : leetCode66.plusOne(digit)) {
            System.out.println(i);
        }
        int[] digit2 = new int[]{9, 9};
        for (int i : leetCode66.plusOne(digit2)) {
            System.out.println(i);
        }
    }

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[]{1};
        }
        int upper = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = upper + digits[i];
            digits[i] = sum % 10;
            upper = sum / 10;
            if (upper == 0) {
                break;
            }
        }

        if (upper != 0) {
            int[] res = new int[digits.length + 1];
            res[0] = upper;
            for (int i = 0; i < digits.length; i++) {
                res[i + 1] = digits[i];
            }
            return res;
        }
        return digits;
    }
}
