package reviews.ali.turn_print;

/**
 * author: zhengxiaohui
 * create time: 2020/11/13 15:17
 * description:
 * <p>
 * *  三个线程交替打印1~99
 * *  如 t1,t2,t3线程打印如下
 * *  t1: 1
 * *  t2: 2
 * *  t3: 3
 * *  t1: 4
 * *  t2: …
 * *
 */
public class TurnPrintQes {
    private static volatile boolean signal1 = true;
    private static volatile boolean signal2 = false;
    private static volatile boolean signal3 = false;

    private final static int PRINT_LIMIT = 100;
    private static volatile int currntNum = 0;


    public static void main(String[] args) {
        Object lock = new Object();

        new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (PRINT_LIMIT <= currntNum) {
                        return;
                    }
                    if (signal1 == true) {
                        System.out.println(Thread.currentThread().getName() + "\t currentNum= " + currntNum);
                        currntNum++;
                        signal1 = false;
                        signal2 = true;
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }).start();


        new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    return;
                }
                synchronized (lock) {
                    if (PRINT_LIMIT <= currntNum) {
                        return;
                    }
                    if (signal2 == true) {
                        System.out.println(Thread.currentThread().getName() + "\t currentNum= " + currntNum);
                        currntNum++;
                        signal2 = false;
                        signal3 = true;
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();


        new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (PRINT_LIMIT <= currntNum) {
                        return;
                    }
                    if (signal3 == true) {
                        System.out.println(Thread.currentThread().getName() + "\t currentNum= " + currntNum);
                        currntNum++;
                        signal3 = false;
                        signal1 = true;
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();

    }

}
