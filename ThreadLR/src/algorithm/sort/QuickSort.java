package algorithm.sort;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/10/21 18:24
 * [description]: 快速排序
 * 最优解： 时间复杂度为 O（logN）；每一次都平分数组的情况
 * 最差解： 时间复杂度为 O（n）；退化为冒泡排序的情况
 */
public class QuickSort {
    public static void main(String[] args) {
        QuickSort qs = new QuickSort();

        int[] q = new int[]{0, 0, 0, 2, 0, 5};
        qs.quickSort(q, 0, q.length - 1);

        for (int i : q) {
            System.out.println(i);
        }
    }

    public void quickSort(int[] q, int l, int r) {
        if (l >= r) {
            return;
        }
        int x = q[(l + r) >> 1], i = l - 1, j = r + 1;
        while (i < j) {
            do ++i; while (q[i] < x);
            do --j; while (q[j] > x);
            if (i < j) {
                int temp = q[i];
                q[i] = q[j];
                q[j] = temp;
            }
        }
        quickSort(q, l, j);
        quickSort(q, j + 1, r);
    }
}

