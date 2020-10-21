package ptOffer;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/9/28 9:07
 * [description]: 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 */
public class Offer10II {
    public static void main(String[] args) {
        Offer10II offer10II = new Offer10II();
        System.out.println(offer10II.numWays(2)); // expect 2
        System.out.println(offer10II.numWays(7)); // expect 21
        System.out.println(offer10II.numWays(0)); // expect 1
        System.out.println();
        System.out.println(offer10II.numWaysN(2)); // expect 2
        System.out.println(offer10II.numWaysN(7)); // expect 21
        System.out.println(offer10II.numWaysN(0)); // expect 1
    }

    public int numWays(int n) {
        int constant = 1000000007;
        if (n == 0) {
            return 1;
        }
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            res[i] = (res[i - 1] + res[i - 2]) % constant;
        }
        return res[n];
    }

    public int numWaysN(int n) {
        int constant = 1000000007;
        if (n == 0) {
            return 1;
        }
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            res[i] = (res[i - 1] + res[i - 2]) % constant;
        }
        return res[n];
    }
}
