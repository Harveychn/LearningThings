package ptOffer;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/10/23 18:49
 * [description]:
 */
public class Offer53 {

    public static void main(String[] args) {
        Offer53 offer53 = new Offer53();
        int[] nums = new int[]{
                2, 2
        };
        System.out.println(offer53.search(nums, 2));
    }

    public int search(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] != target) {
                        return res;
                    }
                    res = j - i + 1;
                }
                return res;
            }
        }
        return res;
    }
}
