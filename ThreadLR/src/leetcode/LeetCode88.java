package leetcode;

import java.util.Arrays;

/**
 * author: zhengxiaohui
 * create time: 2020/11/16 18:11
 * description:
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 *  
 * 说明：
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 */
public class LeetCode88 {

    public static void main(String[] args) {
        LeetCode88 leetCode88 = new LeetCode88();

        int[] nums1 = new int[]{
                2, 5, 6, 0, 0, 0
        };
        int[] num2 = new int[]{
                1, 2, 3
        };

        leetCode88.merge2(nums1, 3, num2, 3);
    }

    // 执行时长耗时较长的解法
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] newNum1 = Arrays.copyOf(nums1, nums1.length);

        int resIndex = 0;

        int x = 0, y = 0;
        while (x < m && y < n) {
            if (newNum1[x] < nums2[y]) {
                nums1[resIndex] = newNum1[x];
                x++;
            } else {
                nums1[resIndex] = nums2[y];
                y++;
            }
            resIndex++;
        }
        for (; x < m; x++) {
            nums1[resIndex] = newNum1[x];
            resIndex++;
        }
        for (; y < n; y++) {
            nums1[resIndex] = nums2[y];
            resIndex++;
        }


        for (int re : nums1) {
            System.out.println(re);
        }
    }

    // 从后往前执行处理计算的解法
    public void merge2(int[] num1, int m, int[] num2, int n) {
        int i = num1.length - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (num1[m] > num2[n]) {
                num1[i] = num1[m];
                m--;
            } else {
                num1[i] = num2[n];
                n--;
            }
            i--;
        }
        while (m >= 0) {
            num1[i] = num1[m];
            i--;
            m--;
        }
        while (n >= 0) {
            num1[i] = num2[n];
            i--;
            n--;
        }

    }
}
