package ptOffer;

import java.util.HashMap;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/10/26 18:42
 * [description]: 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 */
public class Offer57 {
    public static void main(String[] args) {

    }

    // hash法
    public int[] hashMethod(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null) {
            return res;
        }
        HashMap<Integer, Integer> valMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            valMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (target < nums[i]) {
                break;
            }
            int left = target - nums[i];
            if (valMap.containsKey(left)) {
                res[0] = nums[i];
                res[1] = left;
                return res;
            }
        }
        return res;
    }

    // 二分查找法
    public int[] binarySearchMethod(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null) {
            return res;
        }

        for (int i = 0; i < nums.length; i++) {
            int left = target - nums[i];

            int l = i + 1, r = nums.length - 1;
            while (l <= r) {
                int mid = (l + r) >> 1;
                if (nums[mid] == left) {
                    res[0] = nums[i];
                    res[1] = nums[mid];
                    return res;
                }
                if (nums[mid] < left) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

        }
        return res;
    }

    // 双指针法
    public int[] doublePointer(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null) {
            return res;
        }
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == target) {
                res[0] = nums[l];
                res[1] = nums[r];
                return res;
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
        return res;
    }
}
