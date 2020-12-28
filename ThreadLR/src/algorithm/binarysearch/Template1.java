package algorithm.binarysearch;

/**
 * author: zhengxiaohui
 * create time: 2020/12/22 9:11
 * description: TODO
 */
public class Template1 {

    public static void main(String[] args) {

    }

    //START 问题描述1****************************************************************
    /**
     * 猜数字大小
     * 猜数字游戏的规则如下：
     * <p>
     * 每轮游戏，我都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
     * 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
     * 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）：
     * <p>
     * -1：我选出的数字比你猜的数字小 pick < num
     * 1：我选出的数字比你猜的数字大 pick > num
     * 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
     */
    public int guess(int num) {
        int ans = 10;
        if (num == ans) {
            return 0;
        }
        return num - ans > 0 ? 1 : -1;
    }

    /**
     * Forward declaration of guess API.
     *
     * @param n your guess
     * @return -1 if num is lower than the guess number
     * 1 if num is higher than the guess number
     * otherwise return 0
     * <p>
     * 预先定义好了一个 guess 的接口
     * int guess(int num);
     */
    // FIXME 该解法存在超时问题
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int res = guess(mid);
            if (res == 0) {
                return mid;
            }
            if (res > 0) {
                left = mid + 1;
            }
            if (res < 0) {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 三分法处理解决问题思路
     *
     * @param n
     * @return
     */
    public int guessNumber2(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;
            int res1 = guess(mid1);
            int res2 = guess(mid2);

            if (res1 == -1) {
                right = mid1 - 1;
            } else if (res1 == 0) {
                return mid1;
            } else {
                left = mid1 + 1;
            }

            if (res2 == -1) {
                right = mid2 - 1;
            } else if (res2 == 0) {
                return mid2;
            } else {
                left = mid2 + 1;
            }
        }
        return -1;
    }
    //END 问题描述1****************************************************************

    //START 问题描述2****************************************************************
    /**
     * 升序排列的整数数组 nums 在预先未知的某个点上进行了旋转（例如， [0,1,2,4,5,6,7] 经旋转后可能变为 [4,5,6,7,0,1,2] ）。
     *
     * 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
     */


    //END 问题描述2****************************************************************

}
