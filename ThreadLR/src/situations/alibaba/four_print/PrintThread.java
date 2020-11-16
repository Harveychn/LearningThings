package situations.alibaba.four_print;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author: zhengxiaohui
 * create time: 2020/11/10 14:15
 * description: TODO
 */
public class PrintThread implements Runnable {

    // 类变量
    private static volatile int currentIndex = 0;
    private final static Lock lock = new ReentrantLock();
    private final static Condition printCondition = lock.newCondition();

    private int[] toPrintAry;

    private PrintMethod printMethod;
    private PrintTypeEnum printTypeEnum;

    public PrintThread(int[] toPrintAry, PrintTypeEnum printTypeEnum, PrintMethod printMethod) {
        this.toPrintAry = toPrintAry;
        this.printMethod = printMethod;
        this.printTypeEnum = printTypeEnum;
    }


    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                while (currentIndex < toPrintAry.length && printTypeEnum.ordinal() != toPrintAry[currentIndex] % 4) {
                    printCondition.await();
                }
                if (currentIndex < toPrintAry.length) {
                    printMethod.print(toPrintAry[currentIndex]);
                    currentIndex++;
                    printCondition.signalAll();
                } else {
                    return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
