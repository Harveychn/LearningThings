package situations.bytedance;

import java.util.List;
import java.util.Vector;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/9/18 17:15
 * [description]:
 * 给定一个单链表的头节点 head,实现一个调整单链表的函数，使得每K个节点之间为一组进行逆序，
 * 并且从链表的尾部开始组起，头部剩余节点数量不够一组的不需要逆序。（不能使用队列或者栈作为辅助）
 * <p>
 * 例如：
 * 链表:1->2->3->4->5->6->7->8->null, K = 3。那么 6->7->8，3->4->5，1->2各位一组。
 * 调整后：1->2->5->4->3->8->7->6->null。其中 1，2不调整，因为不够一组。
 */
public class QesLinkedListReverse {
    public static void main(String[] args) {
        List<String> test = new Vector<>();
        test.add("123");
        test.add(null);
        System.out.println(test);

    }
}
