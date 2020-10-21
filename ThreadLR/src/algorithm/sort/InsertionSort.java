package algorithm.sort;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/10/12 19:30
 * [description]: 插入排序
 * O(1) 的额外空间的排序
 * 小规模数据或者基本有序时十分高效
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = new int[]{
                3, 5, 15, 23, 4, 323, 234, 32, 1, 234, 34
        };
        InsertionSort sort = new InsertionSort();
        sort.insertionSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }

    }

    public void insertionSort(int[] nums) {
        if (nums == null) {
            return;
        }
        int start = 1;
        while (start < nums.length) {
            for (int i = start - 1; i >= 0; i--) {
                if (nums[start] < nums[i]) {
                    int temp = nums[start];
                    nums[start] = nums[i];
                    nums[i] = temp;
                } else {
                    start++;
                }
            }
        }
    }
}
