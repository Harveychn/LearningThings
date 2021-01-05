package basic;

/**
 * author: zhengxiaohui
 * create time: 2021/1/4 16:11
 * description: TODO
 */
public class JavaLoadProcess {

    private static final String VAL = "const static value";

    private static int CODE2VAL = 123;

    static {
        System.out.println("static block code");
        System.out.println(VAL);
        System.out.println(CODE2VAL);
    }

    public JavaLoadProcess() {
        System.out.println("构造器");
    }

    public static void main(String[] args) {
        System.out.println("静态代码块绝对是线程安全的！只能隐式地被Java虚拟机在类加载过程中初始化调用！");
        System.out.println("main process:");
        System.out.println(VAL);
        System.out.println(CODE2VAL);
    }
}
