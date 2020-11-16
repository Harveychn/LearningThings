package situations.alibaba.four_print;

/**
 * author: zhengxiaohui
 * create time: 2020/11/10 14:18
 * description: TODO
 */
public class PrintMethodImplemation implements PrintMethod {

    @Override
    public void print(int n) {
        if (n % 15 == 0) {
            System.out.println(Thread.currentThread().getId() + "\t" + Thread.currentThread().getName() + "\t" + "C");
        } else if (n % 5 == 0) {
            System.out.println(Thread.currentThread().getId() + "\t" + Thread.currentThread().getName() + "\t" +"B");
        } else if (n % 3 == 0) {
            System.out.println(Thread.currentThread().getId() + "\t" + Thread.currentThread().getName() + "\t" +"A");
        } else {
            System.out.println(Thread.currentThread().getId() + "\t" + Thread.currentThread().getName() + "\t" +n);
        }
    }
}
