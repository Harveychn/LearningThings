package reviews;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/10/26 11:49
 * [description]:
 * 给定一个字符串str，返回str的最长无重复字符串的长度。例如：‘abcd’返回4，’aabcb’返回3。
 */
public class DynamicWindow {

    public static void main(String[] args) {
        DynamicWindow window = new DynamicWindow();
        System.out.println( window.maxLenOfSubStr("abcd"));
        System.out.println( window.maxLenOfSubStr("aabcb"));
        System.out.println(window.maxLenOfSubStr("aabecb"));
    }

    public int maxLenOfSubStr(String str) {
        if (str == null) {
            return 0;
        }
        int left = 0, right = 0, n = str.length(), ans = 0;
        Set<Character> set = new HashSet<>();
        while (left < n && right < n) {
            // 未重复情况下，一直添加到唯一集合, 右边界一直向右移动
            if (!set.contains(str.charAt(right))) {
                set.add(str.charAt(right++));
                ans = Math.max(ans, right - left);
            } else {
                // 出现重复情况下，左边界一直向右移动，直到删除掉所有的重复元素前的元素
                set.remove(str.charAt(left++));
            }
        }
        return ans;
    }

}
