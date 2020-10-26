package ptOffer;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/10/22 8:56
 * [description]:
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 */
public class Offer42 {
    public static void main(String[] args) {
        int[] nums = new int[]{
                -2, 1, -3, 4, -1, 2, 1, -5, 4
        };

        Offer42 offer42 = new Offer42();
        System.out.println(offer42.maxSubArray2(nums));
        System.out.println(offer42.maxSubArray(nums));
    }

    public int maxSubArray2(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // dp表
            nums[i] += Math.max(nums[i - 1], 0);
            max = Math.max(max, nums[i]);
        }
        return max;
    }


    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}
