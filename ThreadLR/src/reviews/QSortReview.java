package reviews;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/10/24 9:58
 * [description]:
 */
public class QSortReview {

    public static void main(String[] args) {
        QSortReview qSortReview = new QSortReview();
        int[] p = new int[]{
                12, 2232, 32, 0, 32, 123, 13, 12, 31, 2312, 3, 1
        };

        System.out.println(p.length);
        qSortReview.quickSort(p, 0, p.length - 1);
        System.out.println(p.length);
        System.out.println();
        for (int i : p) {
            System.out.println(i);
        }
    }

    public void quickSort(int[] p, int left, int right) {
        if (left >= right) {
            return;
        }
        int x = p[(left + right) >> 1], l = left - 1, r = right + 1;
        while (l < r) {
            do l++; while (p[l] < x);
            do r--; while (p[r] > x);
            if (l < r) {
                int temp = p[l];
                p[l] = p[r];
                p[r] = temp;
            }
        }
        quickSort(p, left, r);
        quickSort(p, r + 1, right);
    }
}
