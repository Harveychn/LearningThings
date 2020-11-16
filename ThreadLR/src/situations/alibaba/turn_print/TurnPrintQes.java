package situations.alibaba.turn_print;


/**
 * author: zhengxiaohui
 * create time: 2020/11/10 15:01
 * description: TODO
 */
public class TurnPrintQes {

    public static void main(String[] args) {
        PrintResource resource = new PrintResource();
        new Thread(() -> resource.print(PrintResource.firstCondi, PrintResource.secondCondi)).start();
        new Thread(() -> resource.print(PrintResource.secondCondi, PrintResource.thirdCondi)).start();
        new Thread(() -> resource.print(PrintResource.thirdCondi, PrintResource.firstCondi)).start();
    }
}
