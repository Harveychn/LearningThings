package reviews;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/9/28 11:31
 * [description]: 0 1 2 3 5 8
 */
public class FibTest {
    public static void main(String[] args) {
        FibTest fibTest = new FibTest();
        System.out.println(fibTest.fib(5));
        System.out.println(fibTest.fib(44));
    }

    public int fib(int n) {
        int constant = 1000000007;
        int[] res = new int[n + 1];
        if (n <= 2) {
            return n;
        }
        res[0] = 0;
        res[1] = 1;
        res[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            res[i] = (res[i - 1] + res[i - 2]) % constant;
        }
        return res[n];
    }
}
