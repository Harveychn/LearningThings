package ptOffer;

/**
 * author: zhengxiaohui
 * create time: 2020/11/9 20:07
 * description:
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 */
public class Offer58I {

    public static void main(String[] args) {
        Offer58I offer58I = new Offer58I();
        System.out.println(
                offer58I.reverseWords("a good   example"));
    }


    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }
        String[] arys = s.split("\\s+");
        for (int i = 0; i < arys.length / 2; i++) {
            String temp = arys[i];
            arys[i] = arys[arys.length - i - 1];
            arys[arys.length - i - 1] = temp;
        }
        StringBuilder sb = new StringBuilder();
        for (String ary : arys) {
            sb.append(ary);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
