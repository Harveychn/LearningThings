package algorithm.doublepointer;

import java.util.HashSet;
import java.util.Set;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/10/26 18:14
 * [description]:
 */
public class MaxNoRepeatSubStr {
    public static void main(String[] args) {
        MaxNoRepeatSubStr subStr = new MaxNoRepeatSubStr();
        System.out.println(subStr.maxNoRepeatSubStr("abcd"));
        System.out.println(subStr.maxNoRepeatSubStr("aabcb"));
        System.out.println(subStr.maxNoRepeatSubStr("aabecb"));

        System.out.println(subStr.maxNoRepeatSubStr("123123123"));
        System.out.println(subStr.maxNoRepeatSubStr("abcd"));
        System.out.println(subStr.maxNoRepeatSubStr("abcdaddddsdfsdfs"));
    }

    public int maxNoRepeatSubStr(String str) {
        if (str == null) {
            return 0;
        }
        Set<Character> uniCharSet = new HashSet<>();
        int l = 0, r = 0, n = str.length();
        int ans = 0;
        while (l < n && r < n) {
            if (!uniCharSet.contains(str.charAt(r))) {
                uniCharSet.add(str.charAt(r++));
                ans = Math.max(ans, r - l);
            } else {
                uniCharSet.remove(str.charAt(l++));
            }
        }
        return ans;
    }
}
