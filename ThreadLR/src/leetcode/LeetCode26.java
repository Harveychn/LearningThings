package leetcode;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/9/22 18:21
 * [description]:
 */
public class LeetCode26 {
    public static void main(String[] args) {
        LeetCode26 leetCode26 = new LeetCode26();
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] nums2 = new int[]{1, 1, 2};
        int[] nums3 = new int[]{1, 2};
        System.out.println(leetCode26.removeDuplicates(nums));
        System.out.println(leetCode26.removeDuplicates(nums2));
        System.out.println(leetCode26.removeDuplicates(nums3));
        System.out.println();
        System.out.println(leetCode26.officeAns(nums));
        System.out.println(leetCode26.officeAns(nums2));
        System.out.println(leetCode26.officeAns(nums3));
    }

    public int officeAns(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int p = 0;
        int q = 1;
        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                nums[p + 1] = nums[q];
                p++;
            }
            q++;
        }
        return p + 1;
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int resLen = nums.length;

        for (int i = 0; i < resLen; ) {
            if (nums[i] != nums[i + 1]) {
                i = i + 1;
                if (i + 1 >= nums.length) {
                    resLen--;
                    break;
                }
                continue;
            } else {
                resLen--;
            }

            // 移动元素
            for (int j = i; j < nums.length; j++) {
                if (j + 1 < nums.length) {
                    nums[j] = nums[j + 1];
                }
            }
        }
        return resLen + 1;
    }
}
