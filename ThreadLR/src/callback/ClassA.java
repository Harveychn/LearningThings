package callback;

/**
 * author: zhengxiaohui
 * create time: 2020/12/16 14:07
 * description: TODO
 */
public class ClassA implements CallBack {

    @Override
    public void resolve(String message) {
        System.out.println(this.getClass().getName() + " : " + message);
    }
}
