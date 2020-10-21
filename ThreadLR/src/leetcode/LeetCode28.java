package leetcode;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/9/23 9:59
 * [description]:
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class LeetCode28 {
    public static void main(String[] args) {
        LeetCode28 leetCode28 = new LeetCode28();

        System.out.println(leetCode28.strStr("hello",   "ll"));
        System.out.println(leetCode28.strStr("aaaaa",   "ba"));
        System.out.println(leetCode28.strStr("",   "a"));
        System.out.println(leetCode28.strStr("a",   "a"));
    }

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.trim().equals("") ) {
            return 0;
        }


        for (int i = 0; i < haystack.length(); i++) {
            if (needle.charAt(0) == haystack.charAt(i) && i + needle.length() <= haystack.length()) {
                for (int j = 0; j < needle.length(); j++) {
                    if (needle.charAt(j) != haystack.charAt(i + j)) {
                        break;
                    }
                    if (j + 1 >= needle.length()) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }
}
