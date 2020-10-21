package ptOffer;

import java.util.Arrays;
/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/10/21 9:23
 * [description]:输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */
public class Offer29 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}
        };

        Offer29 offer29 = new Offer29();
        Arrays.stream(offer29.spiralOrder(matrix)).forEach(i -> System.out.println(i));
    }

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length <= 0) {
            return new int[0];
        }
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        int index = 0;
        int capacity = matrix.length * matrix[0].length;
        int[] res = new int[capacity];
        // 终止条件 上下边界以及左右边界重叠
        while (top <= bottom && left <= right) {
            // 从左向右遍历
            for (int i = left; i <= right; i++) {
                if (index >= capacity) {
                    break;
                }
                res[index] = matrix[top][i];
                index++;
            }
            top++;
            // 从上到下遍历
            for (int i = top; i <= bottom; i++) {
                if (index >= capacity) {
                    break;
                }
                res[index] = matrix[i][right];
                index++;

            }
            right--;
            // 从右到左遍历
            for (int i = right; i >= left; i--) {
                if (index >= capacity) {
                    break;
                }
                res[index] = matrix[bottom][i];
                index++;

            }
            bottom--;
            // 从下到上遍历
            for (int i = bottom; i >= top; i--) {

                if (index >= capacity) {
                    break;
                }
                res[index] = matrix[i][left];
                index++;
            }
            left++;
        }
        return res;
    }
}
