package ptOffer;

import java.nio.IntBuffer;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/10/9 19:02
 * [description]:
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * 注意：此题对比原题有改动
 */
public class Offer18 {
    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        while (head.val == val) {
            head = head.next;
        }
        ListNode pre = head, next = head.next;
        while (next != null) {
            if (next.val == val) {
                pre.next = next.next;
                next = next.next;
                continue;
            }
            pre = pre.next;
            next = next.next;
        }
        return head;
    }

    public ListNode deleteNodeCascade(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        head.next = deleteNodeCascade(head, val);
        return head;
    }
}
