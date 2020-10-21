package ptOffer;

import java.util.LinkedList;
import java.util.Stack;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/10/21 12:47
 * [description]:
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 */
public class Offer30 {
    public static void main(String[] args) {
        MinStack2 minStack = new MinStack2();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        minStack.min();
        minStack.pop();
        minStack.min();
    }

    //    空间换时间
    static class MinStack2 {
        private final Stack<Integer> dataList;
        private final Stack<Integer> helpList;

        /**
         * initialize your data structure here.
         */
        public MinStack2() {
            dataList = new Stack<>();
            helpList = new Stack<>();
        }

        public void push(int x) {
            dataList.push(x);
            if (helpList.isEmpty() || helpList.peek() >= x) {
                helpList.push(x);
            }
        }

        public void pop() {
            if (dataList.pop().equals(helpList.peek())) {
                helpList.pop();
            }
        }

        public int top() {
            return dataList.peek();
        }

        public int min() {
            return helpList.peek();
        }
    }

    //    时间换空间
    static class MinStack {

        private final LinkedList<Integer> dataList;
        private Integer min = null;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            this.dataList = new LinkedList<>();
        }

        public void push(int x) {
            if (min == null) {
                min = x;
            } else {
                min = Math.min(x, min);
            }
            // 插入有序
            dataList.addLast(x);
        }

        public void pop() {
            // pop时需要检查是否为抛出最小的元素
            int popVal = dataList.removeLast();

            if (popVal == min) {
                Integer newMin = null;
                for (Integer i : dataList) {
                    if (newMin == null) {
                        newMin = i;
                    } else {
                        newMin = Math.min(newMin, i);
                    }
                }
                min = newMin;
            }
        }

        public int top() {
            return dataList.getLast();
        }

        public int min() {
            return min;
        }
    }
}
