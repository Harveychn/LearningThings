package topics.doublePoint;

/**
 * author: zhengxiaohui
 * create time: 2020/11/26 19:00
 * description: 二分查找课程相关课程信息
 */
public class BinarySearchCourse {

    public static void main(String[] args) {
        BinarySearchCourse bs = new BinarySearchCourse();

        int[] datas = new int[]{
                -1, 0, 3, 5, 9, 12
        };
        System.out.println(bs.search(datas, 9));

        int[] datas2 = new int[]{
                -1, 0, 3, 5, 9, 12
        };
        System.out.println(bs.search(datas2, 2));
    }

    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) >> 1;
            if (nums[mid] < target) {
                i = mid + 1;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /***
     * 二叉查找模板一
     *
     * @param nums
     * @param target
     * @return
     */
    public int template1(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // End Condition: left > right
        return -1;
    }
}
