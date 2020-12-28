package callback.refs;

/**
 * author: zhengxiaohui
 * create time: 2020/12/15 17:25
 * description: TODO
 */
public class Main {

    public static void main(String[] args) {
        Li li = new Li();
        Wang wang = new Wang(li);
        wang.askQuestion("this is wang's question!");
    }

}
