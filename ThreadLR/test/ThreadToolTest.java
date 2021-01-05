import java.util.concurrent.*;

/**
 * author: zhengxiaohui
 * create time: 2021/1/4 9:52
 * description: TODO
 */
public class ThreadToolTest {

    private final static int taskNum = 3;

    public static void main(String[] args) throws InterruptedException {
//        countDownLatch();
//        System.out.println("countDownLatch tst!");
//        cyclicBarrier();
//        System.out.println("\n\ncycleBarrier tst!");
        semaphore();
        System.out.println("\n\nsemaphore tst!");
    }

    public static void countDownLatch() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(taskNum);

        ExecutorService executorService = Executors.newFixedThreadPool(taskNum);
        executorService.submit(() -> {
            Thread.sleep(3000);
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName() + " task done!");
            return Thread.currentThread().getState().name();
        });


        executorService.submit(() -> {
            Thread.sleep(3000);
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName() + " task done!");
            return "task done!";
        });


        executorService.submit(() -> {
            Thread.sleep(3000);
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName() + " task done!");
            return "task done!";
        });

        System.out.println("outer running and going to wait!");
        countDownLatch.await();
        System.out.println("all task done, going to close!");

        executorService.shutdown();
    }

    public static void cyclicBarrier() {
        ExecutorService executorService = Executors.newFixedThreadPool(taskNum);

        CyclicBarrier cyclicBarrier = new CyclicBarrier(taskNum, () -> {
            System.out.println("cyclicBarrier task done!");
            System.out.println("shutdown now!");
            executorService.shutdown();
        });


        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + ": num waiting ["
                    + cyclicBarrier.getNumberWaiting() + "]");
            Thread.sleep(3000);
            cyclicBarrier.await();
            System.out.println(Thread.currentThread().getName() + ": num waiting ["
                    + cyclicBarrier.getNumberWaiting() + "]" + " task done!");
            return Thread.currentThread().getState().name();
        });


        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + ": num waiting ["
                    + cyclicBarrier.getNumberWaiting() + "]");
            Thread.sleep(3000);
            cyclicBarrier.await();
            System.out.println(Thread.currentThread().getName() + ": num waiting ["
                    + cyclicBarrier.getNumberWaiting() + "]" + " task done!");
            return "task done!";
        });


        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + ": num waiting ["
                    + cyclicBarrier.getNumberWaiting() + "]");
            Thread.sleep(3000);
            cyclicBarrier.await();
            System.out.println(Thread.currentThread().getName() + ": num waiting ["
                    + cyclicBarrier.getNumberWaiting() + "]" + " task done!");
            return "task done!";
        });

    }

    public static void semaphore() throws InterruptedException {
        Semaphore semaphore = new Semaphore(taskNum);
        ExecutorService executorService = Executors.newFixedThreadPool(taskNum);

        executorService.submit(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            semaphore.release();
            System.out.println(Thread.currentThread().getName() + " task done!");
        });

        executorService.submit(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            semaphore.release();
            System.out.println(Thread.currentThread().getName() + " task done!");
        });

        executorService.submit(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            semaphore.release();
            System.out.println(Thread.currentThread().getName() + " task done!");
        });

        System.out.println("semaphore running and waiting！");
        semaphore.acquire(taskNum);
        System.out.println("task all done!");
        executorService.shutdown();

    }

}
