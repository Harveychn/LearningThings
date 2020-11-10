package ptOffer;

/**
 * author: zhengxiaohui
 * create time: 2020/11/6 18:25
 * description: 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 */
public class Offer65 {

    public static void main(String[] args) {

    }

    public int add(int a, int b) {
        // TODO 默写背诵位操作代码
        while (b != 0) { // 当进位为0时跳出
            int c = (a & b) << 1; // c = 进位
            a = b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }

}
