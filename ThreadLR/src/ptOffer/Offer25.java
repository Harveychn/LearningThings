package ptOffer;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/10/20 20:39
 * [description]:输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 */
public class Offer25 {
    public static void main(String[] args) {

    }

    public class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode res = null;

        if (l1.val < l2.val) {
            res = l1;
            l1 = l1.next;
        } else {
            res = l2;
            l2 = l2.next;
        }
        ListNode p = res;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                p = p.next;
                l1 = l1.next;
            } else {
                p.next = l2;
                p = p.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return res;
    }

}
