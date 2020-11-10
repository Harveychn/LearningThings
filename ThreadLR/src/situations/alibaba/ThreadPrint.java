package situations.alibaba;

/**
 * author: zhengxiaohui
 * create time: 2020/11/10 11:23
 * description:
 * 给定一个数组[1,2,3,4,5,6,7,8,9....,15]，要求遍历数组，
 * 遇到可以同时被3和5整除的数字，打印C；
 * 遇到仅能被5整除的数字，打印B；
 * 遇到仅能被3整除的数字，打印A；
 * 其他打印数字本身；
 * <p>
 * 要求四个线程，每一个线程执行一个打印方法。
 */
public class ThreadPrint {

    private static int[] toPrintAry = new int[16];

    static {
        for (int i = 1; i <= 16; i++) {
            toPrintAry[i - 1] = i;
        }
    }

    class PrintThread implements Runnable {

        @Override
        public void run() {

        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < toPrintAry.length; i++) {
            System.out.println(toPrintAry[i]);
        }
    }
}
