package thread;

import java.util.concurrent.*;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/10/10 9:15
 * [description]:
 */
public class ScheduledPool {

    static class TstCallable implements Runnable {

        private int index;

        public TstCallable(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            System.out.println("index " + index + "\tname:" + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(8);

        System.out.println("start executor service!");
        for (int i = 0; i < 20; i++) {
            service.scheduleAtFixedRate(new TstCallable(i), 0,5, TimeUnit.SECONDS);
        }

    }
}
