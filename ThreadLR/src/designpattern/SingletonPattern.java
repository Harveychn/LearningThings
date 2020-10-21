package designpattern;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.*;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/9/10 8:29
 * [description]: 单例模式
 */
public class SingletonPattern {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(16);
        CompletionService completionService = new ExecutorCompletionService(executor);
        List<Future> result = new ArrayList<>();
        for (int i = 0; i < 2000; i++) {
            int finalI = i;
            result.add(completionService.submit(() -> {
                System.out.println("i:" + finalI + Calendar.getInstance() + "\n" +
                        "\tThread id is: " + Thread.currentThread().getId() + "\n");
                return Singleton.getInstance();
            }));
        }
        result.forEach(a -> {
            System.out.println(a);
        });


        if (!executor.isShutdown()) {
            executor.shutdown();
        }

    }

    static class Singleton {
        private static volatile Singleton instance = null;

        private Singleton() {

        }

        public static Singleton getInstance() {
            if (instance == null) {
                instance = new Singleton();
            }
            System.out.println("getInstance：" + instance);
            return instance;
        }
    }


}
