package leetcode;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/9/22 17:24
 * [description]: 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class LeetCode21 {
    public static void main(String[] args) {

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode root = new ListNode();
        ListNode p = root;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                p.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            p = p.next;
        }
        while (l1 != null) {
            p.next = new ListNode(l1.val);
            l1 = l1.next;
            p = p.next;
        }
        while (l2 != null) {
            p.next = new ListNode(l2.val);
            l2 = l2.next;
            p = p.next;
        }
        return root.next;
    }
}
