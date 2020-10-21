package ptOffer;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/10/21 17:23
 * [description]:
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class Offer39 {
    public static void main(String[] args) {
        int[] nums = new int[]{
                1, 2, 3, 2, 2, 2, 5, 4, 2
        };
        Offer39 offer39 = new Offer39();
        System.out.println(offer39.majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        int votes = 0;
        int major = 0;

        for (int i = 0; i < nums.length; i++) {
            if (votes == 0) {
                major = nums[i];
                votes++;
                continue;
            }
            if (major != nums[i]) {
                votes--;
            } else {
                votes++;
            }
        }
        return major;
    }
}
