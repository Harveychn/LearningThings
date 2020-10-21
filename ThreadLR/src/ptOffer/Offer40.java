package ptOffer;

import java.util.Arrays;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/10/21 18:15
 * [description]:
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 */
public class Offer40 {
    public static void main(String[] args) {
        Offer40 offer40 = new Offer40();
        int[] arr = new int[]{
                3, 2, 1
        };
        offer40.getLeastNumbers(arr, 2);
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int x = arr[(l + r) >> 1], i = l - 1, j = r + 1;
        while (i < j) {
            do ++i; while (arr[i] < x);
            do --j; while (arr[j] > x);
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        quickSort(arr, l, i);
        quickSort(arr, j + 1, r);
    }

}
