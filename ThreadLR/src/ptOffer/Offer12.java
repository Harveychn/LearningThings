package ptOffer;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/9/28 18:04
 * [description]:
 */
public class Offer12 {
    public static void main(String[] args) {
        Offer12 offer12 = new Offer12();
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        char[][] board2 = new char[][]{
                {'a', 'b'},
                {'c', 'd'}
        };
        System.out.println(offer12.exist(board, "ABCCED"));
        System.out.println(offer12.exist(board2, "abcd"));

    }

    public boolean exist(char[][] board, String word) {
        return false;
    }
}
