package ptOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/10/9 19:49
 * [description]:
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 */
public class Offer22 {
    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        List<Integer> temp = new ArrayList<>();
        while (head != null) {
            temp.add(head.val);
            head = head.next;
        }
        ListNode res = null, p = res;
        for (int i = temp.size() - k; i < temp.size(); i++) {
            if (res == null) {
                res = new ListNode(temp.get(i));
                p = res;
            } else {
                p.next = new ListNode(temp.get(i));
                p = p.next;
            }
        }
        return res;
    }

    // 双指针解法
    public ListNode getKthFromEndDoublePointer(ListNode head, int k) {

        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

}
