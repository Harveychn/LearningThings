package ptOffer;

import java.util.HashSet;
import java.util.Set;

/**
 * author: zhengxiaohui
 * create time: 2020/11/23 9:49
 * description: 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14
 */
public class Offer61 {

    public static void main(String[] args) {
        Offer61 offer61 = new Offer61();
        int[] nums = new int[]{
                1, 2, 3, 4, 5
        };
        System.out.println(offer61.isStraight(nums));
        int[] nums2 = new int[]{
                0, 0, 1, 2, 5
        };
        System.out.println(offer61.isStraight(nums2));
    }

    public boolean isStraight(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<Integer> card = new HashSet<>();
        int numsOfKing = 0;

        for (int num : nums) {
            if (num == 0) {
                numsOfKing++;
                continue;
            }
            if (card.contains(num)) {
                return false;
            }
            min = Math.min(min, num);
            max = Math.max(max, num);
            card.add(num);
        }
        // ? size 不需要控制
        return max - min < 5;
    }
}
