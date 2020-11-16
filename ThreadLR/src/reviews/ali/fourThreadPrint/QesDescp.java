package reviews.ali.fourThreadPrint;

/**
 * author: zhengxiaohui
 * create time: 2020/11/13 14:30
 * description:
 * <p>
 * * * 给定一个数组[1,2,3,4,5,6,7,8,9....,15]，要求遍历数组，
 * * * 1/遇到可以同时被3和5整除的数字，打印C；
 * * * 2/遇到仅能被5整除的数字，打印B；
 * * * 3/遇到仅能被3整除的数字，打印A；
 * * * 4/其他打印数字本身；
 * * * <p>
 * * * 要求四个线程，每一个线程执行一个打印方法。
 */
public class QesDescp {
    private final static int CAPACITY = 16;

    public static void main(String[] args) {
        int[] toPrintData = new int[CAPACITY];
        for (int i = 0; i < CAPACITY; i++) {
            toPrintData[i] = i;
        }

        new Thread(new PrintRunnable(PrintTypeEnum.TYPE_A, toPrintData)).start();
        new Thread(new PrintRunnable(PrintTypeEnum.TYPE_B, toPrintData)).start();
        new Thread(new PrintRunnable(PrintTypeEnum.TYPE_C, toPrintData)).start();
        new Thread(new PrintRunnable(PrintTypeEnum.OTHER, toPrintData)).start();
    }

}
