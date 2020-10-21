package ptOffer;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/9/27 18:50
 * [description]:public String replaceSpace(String s) {
 * <p>
 * }
 */
public class Offer5 {
    public static void main(String[] args) {
        Offer5 offer5 = new Offer5();
        System.out.println(offer5.replaceSpace("We are happy."));
    }

    public String replaceSpace(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                sb.append("%20");
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }

}
