package thread;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/8/21 11:58
 * [description]:
 */
public class StaticSynchronizedDemo {

    private static volatile int count = 1;

    public static int getCount() {
        synchronized (StaticSynchronizedDemo.class) {
            return count++;
        }
    }
}
