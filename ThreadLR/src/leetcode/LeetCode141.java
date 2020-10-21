package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/10/9 18:37
 * [description]:
 */
public class LeetCode141 {
    public static void main(String[] args) {

    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        Set<ListNode> traveled = new HashSet<>();
        while (head != null) {
            if (traveled.contains(head)) {
                return true;
            }
            traveled.add(head);
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode quick = head.next;
        ListNode slow = head;
        while (quick != slow) {
            if (quick == null || quick.next == null) {
                return false;
            }
            quick = quick.next.next;
            slow = slow.next;
        }
        return true;
    }


}
