package ptOffer;

import java.util.Stack;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/10/20 17:24
 * [description]: 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 */
public class Offer24 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode head = null;
        ListNode p = null;
        for (int i = 0; i < 5; i++) {
            if (p == null) {
                head = new ListNode(i + 1);
                p = head;
                continue;
            }
            p.next = new ListNode(i + 1);
            p = p.next;
        }

        Offer24 offer24 = new Offer24();
        offer24.reverseList(head);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        Stack<ListNode> reverseStack = new Stack<>();
        while (head != null) {
            reverseStack.push(head);
            head = head.next;
        }
        ListNode res = null;
        ListNode p = null;
        while (!reverseStack.isEmpty()) {
            if (res == null) {
                res = reverseStack.pop();
                p = res;
                continue;
            }
            p.next = reverseStack.pop();
            p = p.next;
        }
        p.next = null;
        return res;
    }
}
