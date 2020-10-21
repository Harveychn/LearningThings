package reviews;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/10/9 12:07
 * [description]:
 */
public class StaticTst {
    static int i = 123;

    static {
        i = 0;
        System.out.println(i);
    }

    public static void main(String[] args) {
        StaticTst tst = new StaticTst();

    }
}
