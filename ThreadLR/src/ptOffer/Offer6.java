package ptOffer;

import sun.security.jgss.GSSHeader;

import java.util.Stack;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/9/27 18:55
 * [description]:输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */
public class Offer6 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Offer6 offer6 = new Offer6();


    }

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            res[i] = stack.pop();
            i++;
        }
        return res;
    }
}
