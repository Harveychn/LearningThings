package thread.tools;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * author: zhengxiaohui
 * create time: 2021/1/3 15:56
 * description: TODO
 */
public class CountDownDemo {
    private static CountDownLatch countDownLatch = new CountDownLatch(3);
    private static ExecutorService executorService = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws InterruptedException {
        executorService.submit(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + " " + countDownLatch.getCount());
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName() + " " + countDownLatch.getCount());
            }
        });

        executorService.submit(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + " " + countDownLatch.getCount());
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName() + " " + countDownLatch.getCount());
            }
        });

        executorService.submit(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + " " + countDownLatch.getCount());
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName() + " " + countDownLatch.getCount());
            }
        });
        System.out.println(Thread.currentThread().getName() + " main thread running! ");
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + " " + countDownLatch.getCount());
        System.out.println(Thread.currentThread().getName() + " main thread done! ");

        executorService.shutdown();
    }
}
