package ptOffer;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/10/9 18:17
 * [description]:
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。
 * 例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 */
public class Offer15 {
    public static void main(String[] args) {
        Offer15 offer15 = new Offer15();

        System.out.println(offer15.hammingWeight(9));
        System.out.println(offer15.hammingWeight(1));
        System.out.println(offer15.hammingWeight(3));
        System.out.println(offer15.hammingWeight(10));

    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }
}
