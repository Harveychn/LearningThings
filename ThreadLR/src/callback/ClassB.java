package callback;

/**
 * author: zhengxiaohui
 * create time: 2020/12/16 14:12
 * description: TODO
 */
public class ClassB {
    private ClassA classA;

    public ClassB(ClassA classA) {
        this.classA = classA;
    }

    public void executeSomething(CallBack callBack, String someMsg) {
        new Thread(new Runnable() {
            @Override
            public void run() {

                classA.resolve(someMsg);
            }
        }).start();
    }
}
