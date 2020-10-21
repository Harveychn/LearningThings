package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/10/10 18:45
 * [description]:
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null
 */
public class LeetCode142 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head) {
        // 解法二 快慢指针法
        if (head == null || head.next == null) {
            return null;
        }
        ListNode quick = head.next, slow = head;
        while (quick != null && quick.next != null) {
            if (slow == quick) {
                return slow;
            }
            slow = slow.next;
            quick = quick.next.next;
        }
        return null;
        // 解法一 Map
//        if (head == null || head.next == null) {
//            return null;
//        }
//        Map<ListNode, ListNode> visited = new HashMap<>();
//        while (head != null) {
//            if (visited.containsKey(head)) {
//                return visited.get(head);
//            }
//            visited.put(head, head);
//            head = head.next;
//        }
//        return null;
    }

}
