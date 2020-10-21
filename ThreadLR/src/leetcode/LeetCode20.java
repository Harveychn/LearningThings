package leetcode;

import java.util.Stack;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/9/22 14:53
 * [description]:
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class LeetCode20 {
    public static void main(String[] args) {
        LeetCode20 solution = new LeetCode20();
        System.out.println(solution.isValid("[{)]"));
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("{[]}"));
    }

    public boolean isValid(String s) {
        if (s == null || s.trim().equals("")) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                if ('(' != stack.pop()) {
                    return false;
                }
                continue;
            }
            if (s.charAt(i) == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                if ('{' != stack.pop()) {
                    return false;
                }
                continue;
            }
            if (s.charAt(i) == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                if ('[' != stack.pop()) {
                    return false;
                }
                continue;
            }
            stack.push(s.charAt(i));
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }

}
