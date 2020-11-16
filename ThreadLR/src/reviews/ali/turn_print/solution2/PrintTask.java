package reviews.ali.turn_print.solution2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author: zhengxiaohui
 * create time: 2020/11/13 16:10
 * description: TODO
 */
public class PrintTask {
    private static volatile int currentNum = 0;

    private static Lock lock = new ReentrantLock();
    public Condition conditionA = lock.newCondition();
    public Condition conditionB = lock.newCondition();
    public Condition conditionC = lock.newCondition();

    private int limit = 100;

    public void print(Condition cur, Condition next) {
        for (int i = 0; i < limit; i++) {
            lock.lock();
            try {
                if (currentNum >= limit) {
                    return;
                }
                System.out.println(Thread.currentThread().getName() + "\t" + currentNum);
                currentNum++;
                next.signalAll();
                cur.await();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}