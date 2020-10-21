package algorithm.sort;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/10/12 19:01
 * [description]: 冒泡排序
 * 时间复杂度 O(n^2)
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = new int[]{
                3, 5, 15, 23, 4, 323, 234, 32, 1, 234, 34
        };
        BubbleSort sort = new BubbleSort();
        sort.bubbleSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void bubbleSort(int[] nums) {
        if (nums == null) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}
