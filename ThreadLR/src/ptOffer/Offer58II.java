package ptOffer;

/**
 * author: zhengxiaohui
 * create time: 2020/11/23 9:30
 * description:
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 */
public class Offer58II {

    public static void main(String[] args) {
        Offer58II offer58II = new Offer58II();
        System.out.println(offer58II.reverseLeftWords("aa123123", 2));
    }

    public String reverseLeftWords(String s, int n) {
        StringBuilder builder = new StringBuilder();
        builder.append(s, n, s.length() );
        builder.append(s, 0, n );
        return builder.toString();
    }
}
