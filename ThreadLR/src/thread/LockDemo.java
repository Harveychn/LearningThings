package thread;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/8/22 13:52
 * [description]:
 */
public class LockDemo {
    private static long count = 0L;

    public static long addCount() {
        // 类锁
        synchronized (LockDemo.class) {
            count++;
        }
        return count;
    }

    static class LockRunnable implements Callable<Long> {
        private long id;

        public LockRunnable(long id) {
            this.id = id;
        }

        @PostConstruct
        public void test() {
            System.out.println("post construct!");
        }

        @Override
        public Long call() {
            long result = LockDemo.addCount();
            System.out.println("Index id:" + this.id
                    + "\tThread id: " + Thread.currentThread().getId()
                    + "\tThread name: " + Thread.currentThread().getName()
                    + "\tresult: " + result);
            return result;
        }
    }

    public static void main(String[] args) {
        ExecutorService taskPool = Executors.newFixedThreadPool(16);
        try {
            int REQUEST_NUM = 10000;

            CompletionService<Long> service = new ExecutorCompletionService<>(taskPool);

            // 提交任务
            for (int i = 0; i < REQUEST_NUM; i++) {
                service.submit(new LockRunnable(i));
            }

            List<Long> results = new ArrayList<>();

            // 获取结果
            for (int i = 0; i < REQUEST_NUM; i++) {
                results.add(service.take().get());
            }
            assert results.size() == REQUEST_NUM;

            // 输出结果
            Collections.sort(results);
            results.forEach(a -> System.out.println(" results: " + a));

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            taskPool.shutdown();
        }
    }
}
