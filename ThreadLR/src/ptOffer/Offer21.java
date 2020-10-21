package ptOffer;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/10/9 19:36
 * [description]:
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 */
public class Offer21 {
    public static void main(String[] args) {
        Offer21 offer21 = new Offer21();
        int[] tst = new int[]{
                1, 2, 3, 4
        };
        for (int i : offer21.exchange(tst)) {
            System.out.println(i);
        }
    }

    public int[] exchange(int[] nums) {
        if (nums == null) {
            return null;
        }
        int[] res = new int[nums.length];
        for (int i = 0, left = 0, right = nums.length - 1; i < nums.length; i++) {
            if (nums[i] % 2 != 0) { // 奇数
                res[left] = nums[i];
                left++;
            } else { // 偶数
                res[right] = nums[i];
                right--;
            }
        }
        return res;
    }
}
