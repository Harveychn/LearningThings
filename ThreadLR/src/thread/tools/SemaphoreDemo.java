package thread.tools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * author: zhengxiaohui
 * create time: 2021/1/3 16:20
 * description: TODO
 */
public class SemaphoreDemo {
    private static int num = 3;
    private static int initNum = 0;
    private static Semaphore semaphore = new Semaphore(initNum);
    private static ExecutorService executorService = Executors.newFixedThreadPool(num);


    public static void main(String[] args) {
        executorService.submit(() -> {
            try {
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName() + " work done！");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.submit(() -> {
            try {
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName() + " work done！");
                semaphore.release(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        try {
            semaphore.acquire(1);
            System.out.println("acquire 1");
            semaphore.acquire(num - 1);
            System.out.println("acquire " + (num - 1));
            System.out.println("main done!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
        System.out.println("executorService.shutdown()!");
    }
}
