package ptOffer;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * author: zhengxiaohui
 * create time: 2020/11/6 18:46
 * description: 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 */
public class Offer59I {
    public static void main(String[] args) {

    }

    public int[] maxSlidingWindowBest(int[] nums, int k) {
        // 判空条件
        if (nums.length == 0 || k == 0) return new int[0];

        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];

        for (int i = 0; i < k; i++) { // 未形成窗口
            while (!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();

        for (int i = k; i < nums.length; i++) { // 形成窗口后
            if (deque.peekFirst() == nums[i - k])
                deque.removeFirst();
            while (!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }

    // 暴力解法
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k == 0) {
            return new int[]{};
        }
        int[] res = new int[nums.length - k + 1];

        Queue<Integer> kQ = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            kQ.add(nums[i]);
        }

        res[0] = getMax(kQ);

        int i = 1;
        while (k < nums.length) {
            kQ.poll();
            kQ.add(nums[k]);
            res[i] = getMax(kQ);
            i++;
            k++;
        }
        return res;
    }

    private int getMax(Queue<Integer> kq) {
        int max = Integer.MIN_VALUE;
        if (kq == null) {
            return 0;
        }

        for (Integer integer : kq) {
            max = Math.max(integer, max);
        }
        return max;
    }
}
