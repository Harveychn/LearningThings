package thread;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/10/20 12:53
 * [description]:
 */
public class SynTstDemo {
    public static void main(String[] args) throws InterruptedException {
        LockDemo lockDemo = new LockDemo();
        lockDemo.wait();
        synchronized (lockDemo) {
            System.out.println("wait");
            lockDemo.wait();
            System.out.println("notify");
            lockDemo.notify();
        }
    }



}
