package reviews.ali.fourThreadPrint;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author: zhengxiaohui
 * create time: 2020/11/13 14:48
 * description: TODO
 */
public class PrintRunnable implements Runnable {
    private static volatile int currentIndex = 0;
    private static final Lock lock = new ReentrantLock();
    private static final Condition printCondition = lock.newCondition();

    private int[] toPrintData;
    private PrintTypeEnum printTypeEnum;

    public PrintRunnable(PrintTypeEnum printTypeEnum, int[] toPrintData) {
        this.toPrintData = toPrintData;
        this.printTypeEnum = printTypeEnum;
    }

    private boolean isMyTask(int n) {
        int myType = printTypeEnum.ordinal();
        if (n % 4 == myType) {
            return true;
        }
        return false;
    }

    public void printMethod(int n) {
        if (n % 15 == 0) {
            System.out.println(Thread.currentThread().getName() + "\tn= " + n + "\tC");
        } else if (n % 5 == 0) {
            System.out.println(Thread.currentThread().getName() + "\tn= " + n + "\tB");
        } else if (n % 3 == 0) {
            System.out.println(Thread.currentThread().getName() + "\tn= " + n + "\tA");
        } else {
            System.out.println(Thread.currentThread().getName() + "\tn= " + n);
        }
    }

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                if (currentIndex >= toPrintData.length) {
                    return;
                }
                // 判断当前打印任务是否为当前线程的任务
                if (isMyTask(currentIndex)) {
                    printMethod(toPrintData[currentIndex]);
                    currentIndex++;
                    printCondition.signalAll();
                } else {
                    printCondition.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
