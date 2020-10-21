package thread;

import pojo.Person;

import java.util.concurrent.Callable;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/8/20 19:59
 * [description]:
 */
public class CallableDemo implements Callable<Person> {
    @Override
    public Person call() {
        long id = (long) (Math.random() * 100);
//        System.out.println("Thread id is " + Thread.currentThread().getId() + "\t" + Thread.currentThread().getName());
        return new Person(id, "user-" + id, StaticSynchronizedDemo.getCount());
    }
}
