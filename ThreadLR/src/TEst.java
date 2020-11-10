import java.util.*;

public class TEst {

    //    输入描述
    //    输入一串字符。
    //
    //    输出描述
    //            对字符中的
    //    各个英文字符（大小写分开统计），
    //    数字，空格进行统计，并按照统计个数由多到少输出,如果统计的个数相同，
    //    则按照ASII码由小到大排序输出 。如果有其他字符，则对这些字符不用进行统计。
    //    输入
    //        aadddccddc
    //    输出
    //        dca
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        if (input == null) {
            return;
        }
        char[] inChar = input.toCharArray();

        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < inChar.length; i++) {
            if (inChar[i] > 'a' && inChar[i] < 'z' || inChar[i] > 'A' && inChar[i] < 'Z') {
                charMap.put(inChar[i], charMap.getOrDefault(inChar[i], 0) + 1);
            }
        }

        LinkedList<Character> list = new LinkedList<>();
        Set<Character> keys = charMap.keySet();
        for (Character key : keys) {
            if (list.size() == 0) {
                list.addFirst(key);
                continue;
            }
            int count = charMap.get(key);
            // LinkedList查询插入位置
            charMap.get(list.getFirst());
        }

    }
}

