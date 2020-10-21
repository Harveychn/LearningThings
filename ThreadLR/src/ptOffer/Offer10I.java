package ptOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/9/28 8:36
 * [description]: 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 */
public class Offer10I {
    public static void main(String[] args) {
        Offer10I offer10I = new Offer10I();
        System.out.println(offer10I.fib(2));
        System.out.println(offer10I.fib(3));
        System.out.println(offer10I.fib(5));
        System.out.println(offer10I.fib(44));
        System.out.println();
        System.out.println(offer10I.fibLinear(2));
        System.out.println(offer10I.fibLinear(3));
        System.out.println(offer10I.fibLinear(5));
        System.out.println(offer10I.fibLinear(44));
        System.out.println();
        System.out.println(offer10I.fibN(2));
        System.out.println(offer10I.fibN(3));
        System.out.println(offer10I.fibN(5));
        System.out.println(offer10I.fibN(44));
    }

    int constant = 1000000007;

    public int fibN(int n) {
        if (n < 2) {
            return n;
        }
        if (n == 2) {
            return 1;
        }
        int constant = 1000000007;
        int[] res = new int[n + 1];
        res[0] = 0;
        res[1] = 1;
        //  计算公式: f(n) = f(n-1) + f(n-2)
        res[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            res[i] = (res[i - 1] + res[i - 2]) % constant;
        }
        return res[n];
    }

    public int fib(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        return fib(n, map);
    }

    public int fib(int n, Map<Integer, Integer> map) {
        if (n < 2) {
            return n;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int first = fib(n - 1, map) % constant;
        map.put(n - 1, first);
        int second = fib(n - 2, map) % constant;
        map.put(n - 2, second);
        int res = (first + second) % constant;
        map.put(n, res);
        return res;
    }

    public int fibLinear(int n) {
        int constant = 1000000007;
        int first = 0;
        int second = 1;
        while (n-- > 0) {
            int temp = first + second;
            first = second % constant;
            second = temp % constant;
        }
        return first;
    }
}
