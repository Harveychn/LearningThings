package ptOffer;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/9/28 17:50
 * [description]:
 * <p>
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 */
public class Offer11 {
    public static void main(String[] args) {
        Offer11 offer11 = new Offer11();
        int[] nums = new int[]{
                3, 4, 5, 1, 2
        };
        int[] nums2 = new int[]{
                2, 2, 2, 0, 1
        };
        System.out.println(offer11.minArray(nums));
        System.out.println(offer11.minArray(nums2));
    }

    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length <= 0) {
            return 0;
        }
        int i = 0, j = i + 1;
        while (j < numbers.length) {
            if (numbers[i] > numbers[j]) {
                return numbers[j];
            }
            i++;
            j++;
        }

        return numbers[0];
    }

}
