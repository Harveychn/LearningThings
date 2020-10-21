package algorithm.sort;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/10/12 19:12
 * [description]: 选择排序
 * 表现最稳定的 排序算法之一 时间复杂度 O(n^2)
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = new int[]{
                3, 5, 15, 23, 4, 323, 234, 32, 1, 234, 34
        };
        SelectionSort sort = new SelectionSort();
        sort.selectSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void selectSort(int[] nums) {
        if (nums == null) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int change = i; // 记录最小值
            for (int j = i; j < nums.length; j++) {
                if (nums[change] > nums[j]) {
                    change = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[change];
            nums[change] = temp;
        }
    }

}
