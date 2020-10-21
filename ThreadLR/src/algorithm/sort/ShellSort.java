package algorithm.sort;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/10/12 19:49
 * [description]:
 * 使用场景： 较大规模并且无序的数据也效率高
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] nums = new int[]{
                3, 5, 15, 23, 4, 323, 234, 32, 1, 234, 34
        };
        ShellSort sort = new ShellSort();
        sort.shellSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void shellSort(int[] nums) {
        int n = nums.length;
        // 分组处理，最开始时的增量gap为数组长度的一半
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // 对各个分组进行插入排序
            for (int i = gap; i < n; i++) {
                // 将arr[i] 插入到所在分组的正确位置上
                insertI(nums, gap, i);
            }
        }
    }

    private void insertI(int[] nums, int gap, int i) {
        int inserted = nums[i];
        int j;
        for (j = i - gap; j >= 0 && inserted < nums[j]; j -= gap) {
            nums[j + gap] = nums[j];
        }
        nums[j + gap] = inserted;
    }
}
