package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/9/21 19:03
 * [description]: 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LeetCode5 {
    public static void main(String[] args) {
        String str = "babad";
        System.out.println(longestPalindrome(str));
        String str2 = "cbbd";
        System.out.println(longestPalindrome(str2));
    }

    public static int longestPalindrome(String s) {
        char[] ary = s.toCharArray();
        int max = 0;



        return max;
    }
}
