package situations.alibaba.turn_print;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author: zhengxiaohui
 * create time: 2020/11/10 15:02
 * description: TODO
 */
public class PrintResource {
    private static volatile int nums = 1;

    private static Lock lock = new ReentrantLock();

    public static Condition firstCondi = lock.newCondition();
    public static Condition secondCondi = lock.newCondition();
    public static Condition thirdCondi = lock.newCondition();

    public void print(Condition pre, Condition next) {
        lock.lock();
        try {
            while (nums <= 99) {
                System.out.println("线程" + Thread.currentThread().getName() + "打印num当前值" + nums);
                nums++;
                next.signal();
                pre.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
