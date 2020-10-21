package reviews;


/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/9/20 17:06
 * [description]:
 */
public class DemoTest {

    public static void main(String[] args) {
        String a = "199";
        String b = "23";
//
        StringBuilder aSb = new StringBuilder(a);
        StringBuilder bSb = new StringBuilder(b);

        char[] aAry = aSb.reverse().toString().toCharArray();
        char[] bAry = bSb.reverse().toString().toCharArray();

        StringBuilder res = new StringBuilder();

        int upper = 0;
        int i = 0;
        int times = a.length() >= b.length() ? b.length() : a.length();
        int sum = 0;
        for (; i < times; i++) {
            sum = (aAry[i] - '0') + (bAry[i] - '0') + upper;
//            System.out.println(sum);
//            System.out.println(aAry[i]);
//            System.out.println(bAry[i]);
            upper = sum / 10;
            if (i + 1 < times) {
                res.append(sum % 10);
            }
        }

        if (upper != 0) {
            res.append(upper + sum % 10);
        }
        System.out.println(res.reverse().toString());

    }
}
