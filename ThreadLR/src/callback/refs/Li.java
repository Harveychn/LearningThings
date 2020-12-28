package callback.refs;

/**
 * author: zhengxiaohui
 * create time: 2020/12/15 17:16
 * description: TODO
 */
public class Li {
    /**
     * 相当于B类有参数为CallBack callBack的f()，回调机制特点3
     *
     * @param callBack
     * @param question 小王问的问题
     */
    public void executeMessage(Callback callBack, String question) {
        System.out.println("wang's question is --->" + question);
        //模拟小李办自己的事情需要很长时间
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /**
         * 小李办完自己的事情之后想到了答案是2
         */
        String result = "this is you answer";

        /**
         * 于是就打电话告诉小王，调用小王中的方法
         * 这就相当于B类反过来调用A的方法
         */
        callBack.solve(result);
    }
}
