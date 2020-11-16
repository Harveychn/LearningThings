package reviews.ali.turn_print.solution2;


/**
 * author: zhengxiaohui
 * create time: 2020/11/13 15:59
 * description: condition方式实现
 */
public class TurnPrintQesCondition {

    public static void main(String[] args) {
        PrintTask printTask = new PrintTask();
        new Thread(() -> printTask.print(printTask.conditionA, printTask.conditionB)).start();
        new Thread(() -> printTask.print(printTask.conditionB, printTask.conditionC)).start();
        new Thread(() -> printTask.print(printTask.conditionC, printTask.conditionA)).start();
    }
}
