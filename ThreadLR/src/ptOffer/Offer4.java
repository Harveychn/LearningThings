package ptOffer;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/9/26 13:41
 * [description]:
 */
public class Offer4 {
    public static void main(String[] args) {
        Offer4 offer4 = new Offer4();
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int[][] matrix2 = new int[][]{
                {1, 1}
        };
        System.out.println(offer4.findNumberIn2DArray(matrix, 5));
        System.out.println(offer4.findNumberIn2DArray(matrix, 20));
        System.out.println(offer4.findNumberIn2DArray(matrix2, 0));
        System.out.println();
        System.out.println(offer4.findNumberIn2DArrayReview(matrix, 5));
        System.out.println(offer4.findNumberIn2DArrayReview(matrix, 20));
        System.out.println(offer4.findNumberIn2DArrayReview(matrix2, 0));
        System.out.println();

    }

    public boolean findNumberIn2DArrayReview(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }

        return false;
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length <= 0) {
            return false;
        }

        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] < target) {
                j++;
            } else if (matrix[i][j] > target) {
                i--;
            } else {
                return true;
            }
        }
        return false;
    }
}