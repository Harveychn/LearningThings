package ptOffer;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/10/9 18:29
 * [description]:
 */
public class Offer17 {
    public static void main(String[] args) {
        Offer17 offer17 = new Offer17();
        offer17.printNumbers(2);
    }

    public int[] printNumbers(int n) {
        int count = (int) Math.pow(10, n);
        int[] res = new int[count - 1];
        for (int i = 1; i < count; i++) {
            res[i - 1] = i;
        }
        return res;
    }

}
