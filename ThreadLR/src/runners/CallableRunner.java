package runners;

import pojo.Person;
import thread.CallableDemo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/8/20 20:02
 * [description]:
 */
public class CallableRunner {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(8);


        Future<Person> task =
                executor.submit(new CallableDemo());

        while (!task.isDone()) {
            System.out.println("poll request... ");
            Thread.yield();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(task.get().toString());
        System.out.println("task done! ");

        executor.shutdown();
    }
}
