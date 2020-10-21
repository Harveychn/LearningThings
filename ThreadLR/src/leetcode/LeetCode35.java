package leetcode;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/9/23 13:41
 * [description]:
 * <p>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */
public class LeetCode35 {
    public static void main(String[] args) {
        int[] tst1 = new int[]{
                1, 3, 5, 6
        };

        int[] tst2 = new int[]{
                1, 3, 5, 6
        };

        int[] tst3 = new int[]{
                1, 3, 5, 6
        };

        int[] tst4 = new int[]{
                1, 3, 5, 6
        };

        LeetCode35 leetCode35 = new LeetCode35();
        System.out.println(leetCode35.searchInsert(tst1, 5));
        System.out.println(leetCode35.searchInsert(tst2, 2));
        System.out.println(leetCode35.searchInsert(tst3, 7));
        System.out.println(leetCode35.searchInsert(tst4, 0));
    }

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (target < nums[i]) {
                return i;
            } else if (target == nums[i]) {
                return i;
            } else {
                if (i + 1 >= nums.length) {
                    return i + 1;
                }
                if (target < nums[i + 1]) {
                    return i + 1;
                }
            }
        }
        return nums.length;
    }
}
