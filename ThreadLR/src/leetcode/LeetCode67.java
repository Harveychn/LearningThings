package leetcode;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/9/24 18:26
 * [description]:
 */
public class LeetCode67 {
    public static void main(String[] args) {
        LeetCode67 leetCode67 = new LeetCode67();
        System.out.println(leetCode67.addBinary("11", "1"));
        System.out.println(leetCode67.addBinary("1010", "1011"));
    }

    public String addBinary(String a, String b) {
        if (a == null && b == null) {
            return "";
        }
        if (a == null || b == null) {
            return a == null ? b : a;
        }

        int upper = 0;
        StringBuilder res = new StringBuilder();
        int maxLen = Math.max(a.length(), b.length());
        for (int i = 0; i < maxLen; i++) {
            int sum = upper;
            if (i < a.length()) {
                upper += (a.charAt(a.length() - 1 - i) - '0');
            }
            if (i < b.length()) {
                upper += (b.charAt(b.length() - 1 - i) - '0');
            }
            res.append(upper % 2);
            upper = upper / 2;
        }
        if (upper != 0) {
            res.append(upper);
        }
        return res.reverse().toString();
    }
}
