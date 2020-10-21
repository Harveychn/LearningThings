package situations.bytedance;


/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/9/21 17:49
 * [description]: 长int相加求和
 */
public class LongIntSum {

    public static void main(String[] args) {
        // 自己实现要如何实现
        String a = "199";
        String b = "101";
        System.out.println(byteMethod(a, b));
    }

    public static String byteMethod(String a, String b) {
        if (a == null && b == null) {
            return "0";
        }
        if (a == null || b == null) {
            return a == null ? b : a;
        }

        char[] aAry = a.toCharArray();
        char[] bAry = b.toCharArray();

        StringBuilder res = new StringBuilder();
        int sum = 0;
        for (int i = 0; i < aAry.length || i < bAry.length; i++) {
            if (i < aAry.length) {
                sum += aAry[aAry.length - 1 - i] - '0';
            }
            if (i < bAry.length) {
                sum += bAry[bAry.length - 1 - i] - '0';
            }
            res.append(sum % 10);
            sum = sum / 10;
        }
        return res.reverse().toString();
    }

    public static void reverseMethod() {
        String a = "199";
        String b = "51231";

        StringBuilder aB = new StringBuilder(a);
        a = aB.reverse().toString();
        char[] aAry = a.toCharArray();

        StringBuilder bB = new StringBuilder(b);
        b = bB.reverse().toString();
        char[] bAry = b.toCharArray();

        StringBuilder res = new StringBuilder();
        int len = Math.max(a.length(), b.length());
        int sum = 0;
        for (int i = 0; i < len; i++) {
            if (i < a.length()) {
                sum += aAry[i] - '0';
            }
            if (i < b.length()) {
                sum += bAry[i] - '0';
            }
            res.append(sum % 10);
            sum = sum / 10;
        }
        if (sum != 0) {
            res.append(sum);
        }
        System.out.println(res.reverse().toString());
    }

}
