package ptOffer;

import java.util.Stack;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/9/27 19:06
 * [description]:
 * <p>
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 */
public class Offer9 {
    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.deleteHead();
        cQueue.appendTail(5);
        cQueue.appendTail(2);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }


    static class CQueue {

        private Stack<Integer> ascStack;
        private Stack<Integer> descStack;

        public CQueue() {
            ascStack = new Stack<>();
            descStack = new Stack<>();
        }

        public void appendTail(int value) {
            ascStack.add(value);
        }

        public int deleteHead() {
            while (ascStack.size() > 1) {
                descStack.add(ascStack.pop());
            }
            if (ascStack.size() <= 0) {
                return -1;
            }
            int res = ascStack.pop();
            while (descStack.size() > 0) {
                ascStack.add(descStack.pop());
            }
            return res;
        }
    }
}
