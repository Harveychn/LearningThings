package leetcode;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/9/21 20:06
 * [description]:
 */
public class LeetCode9 {
    public static void main(String[] args) {
        LeetCode9 leetCode9 = new LeetCode9();
        int num = 1000202001;
        System.out.println(leetCode9.isPalindrome(num));
        System.out.println(leetCode9.isPalindrome2(num));
    }

    public boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        int div = 1;
        while (x / div >= 10) div *= 10;
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) {
                return false;
            }
            x = x % div / 10;
            div /= 100;
        }
        return true;
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String val = String.valueOf(x);
        char[] vals = val.toCharArray();
        if (val.length() == 1) {
            return true;
        }
        int length = vals.length / 2;
        for (int i = 0; i < length; i++) {
            if (vals[i] != vals[vals.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
