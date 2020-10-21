package leetcode;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/9/23 9:26
 * [description]:\
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class LeetCode27 {
    public static void main(String[] args) {
        int[] tst1 = new int[]{3, 2, 2, 3};
        int[] tst2 = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int[] tst3 = new int[]{1};
        int[] tst4 = new int[]{3, 3};
        LeetCode27 leetCode27 = new LeetCode27();
        System.out.println(leetCode27.removeElement(tst1, 3));
        System.out.println(leetCode27.removeElement(tst2, 2));
        System.out.println(leetCode27.removeElement(tst3, 1));
        System.out.println(leetCode27.removeElement(tst4, 3));
    }

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int p = 0;
        int q = nums.length - 1;
        while (p <= q) {
            if (nums[p] == val) {
                if (nums[q] == val) {
                    q--;
                } else {
                    nums[p] = nums[q];
                    p++;
                    q--;
                }
            } else {
                p++;
            }
        }

        return p;
    }
}
