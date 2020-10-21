package runners;

import pojo.Person;
import thread.CallableDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/8/21 8:08
 * [description]:
 */
public class CompletionRunner {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(8);
        try {
            int taskCount = Integer.MAX_VALUE;
            List<Person> results = new ArrayList<>();
            List<Future<Person>> taskList = new ArrayList<>();

            CompletionService<Person> completionService = new ExecutorCompletionService<>(service);
            for (int i = 0; i < taskCount; i++) {
                Future<Person> aTask = completionService.submit(new CallableDemo());
                taskList.add(aTask);
            }

            for (int i = 0; i < taskCount; i++) {
                Person personResult = completionService.take().get();
                results.add(personResult);
            }

            System.out.println("completionService result:");
            for (int i = 0; i < taskCount; i++) {
                System.out.println("index: " + (i + 1) + "\t\ttask result: " + results.get(i).toString());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
            System.err.println();
        } finally {
//            if (!service.isShutdown()) {
//                service.shutdown();
//            }
        }
    }

}
