package callback.refs;

/**
 * author: zhengxiaohui
 * create time: 2020/12/15 17:15
 * description: TODO
 */
public class Wang implements Callback {
    /**
     * 小李对象的引用 相当回调机制特点2
     */
    private Li li;

    /**
     * 小王的构造方法，持有小李的引用
     *
     * @param li
     */
    public Wang(Li li) {
        this.li = li;
    }

    /**
     * 小王通过这个方法去问小李的问题
     *
     * @param question 就是小王要问的问题,1 + 1 = ?
     */
    public void askQuestion(final String question) {
        //这里用一个线程就是异步，
        new Thread(new Runnable() {
            @Override
            public void run() {
                /**
                 * 小王调用小李中的方法，在这里注册回调接口
                 * 体现的类A调用类B
                 */
                Callback callback = Wang.this;
                li.executeMessage(callback, question);
            }
        }).start();
        //小网问完问题挂掉电话就去干其他的事情
        play();
    }

    public void play() {
        System.out.println("wang：我去忙了");
    }

    /**
     * 小李知道答案后调用此方法告诉小王，就是所谓的小王的回调方法
     * 小李调用小王的这个方法
     */
    @Override
    public void solve(String result) {
        System.out.println("li to wang ‘s question answer is --->" + result);
    }
}

