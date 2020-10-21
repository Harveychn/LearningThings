package reviews;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/9/25 9:10
 * [description]:
 */
public class Test {
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 64) ? 64 : n + 1;
    }

    public static void main(String[] args) {
        System.out.println(1 << 4);
        System.out.println(tableSizeFor(3));
        System.out.println(tableSizeFor(10));
        System.out.println(tableSizeFor(30));

        int COUNT_BITS = Integer.SIZE - 3;


        final int RUNNING = -1 << COUNT_BITS;
        final int SHUTDOWN = 0 << COUNT_BITS;
        final int STOP = 1 << COUNT_BITS;
        final int TIDYING = 2 << COUNT_BITS;
        final int TERMINATED = 3 << COUNT_BITS;

        System.out.println(RUNNING);
        System.out.println(SHUTDOWN);
        System.out.println(STOP);
        System.out.println(TIDYING);
        System.out.println(TERMINATED);
    }

}
