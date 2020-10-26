package ptOffer;

import java.util.*;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/10/22 9:34
 * [description]:
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母
 */
public class Offer50 {
    public static void main(String[] args) {
        Offer50 offer50 = new Offer50();
        System.out.println(offer50.firstUniqChar("abaccdeff"));
    }

    public char firstUniqChar(String s) {
        HashMap<Character, Boolean> containsChar = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            containsChar.put(s.charAt(i), (containsChar.containsKey(s.charAt(i))));
        }
        for (int i = 0; i < s.length(); i++) {
            if (!containsChar.get(s.charAt(i))) {
                return s.charAt(i);
            }
        }
        return ' ';

    }

    public char firstUniqChar2(String s) {
        LinkedHashMap<Character, Boolean> orderMap = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            orderMap.put(s.charAt(i), (orderMap.containsKey(s.charAt(i))));
        }
        for (Map.Entry<Character, Boolean> entry : orderMap.entrySet()) {
            if (!entry.getValue()) {
                return entry.getKey();
            }
        }
        return ' ';
    }
}
