package ptOffer;

import java.util.*;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/9/26 11:13
 * [description]:
 * 找出数组中重复的数字。
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 */
public class Offer3 {
    public static void main(String[] args) {
        int[] tst = new int[]{
                2, 3, 1, 0, 2, 5, 3
        };
        Offer3 offer3 = new Offer3();
        System.out.println(offer3.findRepeatNumber(tst));
        System.out.println(offer3.findRepeatNumber2(tst));
    }

    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }

        Set<Integer> numsSet = new HashSet<>(); // 判断是否已经遍历过至
        Map<Integer, Integer> repeatNum = new HashMap<>(); // 重复的具体数字

        for (int i = 0; i < nums.length; i++) {
            if (numsSet.contains(nums[i])) {
                repeatNum.put(nums[i], repeatNum.getOrDefault(i, 0) + 1);
            }
            numsSet.add(nums[i]);
        }

        if (repeatNum.size() == 0) {
            return 0;
        }
        return repeatNum.keySet().iterator().next();
    }

    // TODO 仔细研究？？？
    public int findRepeatNumber2(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }

        for (int i = 0; i < nums.length; i++) {
            int temp;
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}
