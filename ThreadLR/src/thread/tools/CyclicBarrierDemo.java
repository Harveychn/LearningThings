package thread.tools;

import java.util.concurrent.*;

/**
 * author: zhengxiaohui
 * create time: 2021/1/3 16:11
 * description: TODO
 */
public class CyclicBarrierDemo {

    private static int num = 3;

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(num, () -> {
        System.out.println("barrier done! ");
        System.out.println("------");
    });

    private static ExecutorService executorService = Executors.newFixedThreadPool(4);

    public static void main(String[] args) {
        executorService.submit(() -> {
            try {
                Thread.sleep(4000);
                System.out.println(Thread.currentThread().getName() + " 's work done!");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        executorService.submit(() -> {
            try {
                Thread.sleep(4000);
                System.out.println(Thread.currentThread().getName() + " 's work done!");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        executorService.submit(() -> {
            try {
                Thread.sleep(4000);
                System.out.println(Thread.currentThread().getName() + " 's work done!");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });


        executorService.shutdown();
    }
}
