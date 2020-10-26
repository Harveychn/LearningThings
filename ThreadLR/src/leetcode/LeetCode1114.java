package leetcode;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/10/22 12:35
 * [description]:
 */
public class LeetCode1114 {
    public static void main(String[] args) {

    }

    class Foo {
        CountDownLatch second = new CountDownLatch(1);
        CountDownLatch third = new CountDownLatch(1);

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            second.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {

            second.await();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            third.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {
            third.await();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

    class FooSemaphare {
        private Semaphore seamFirst2Two = new Semaphore(0);
        private Semaphore seamTwo2Three = new Semaphore(0);

        public FooSemaphare() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            seamFirst2Two.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            seamFirst2Two.acquire();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            seamTwo2Three.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            seamTwo2Three.acquire();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }


    class FooSync {
        private boolean firstFinished;
        private boolean secondFinished;
        private final Object lock = new Object();

        public FooSync() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            synchronized (lock) {
                // printFirst.run() outputs "first". Do not change or remove this line.
                printFirst.run();
                firstFinished = true;
                lock.notifyAll();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            synchronized (lock) {
                while (!firstFinished) {
                    lock.wait();
                }
                // printSecond.run() outputs "second". Do not change or remove this line.
                printSecond.run();
                secondFinished = true;
                lock.notifyAll();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            synchronized (lock) {
                while (!secondFinished) {
                    lock.wait();
                }
                // printThird.run() outputs "third". Do not change or remove this line.
                printThird.run();
            }
        }
    }
}
