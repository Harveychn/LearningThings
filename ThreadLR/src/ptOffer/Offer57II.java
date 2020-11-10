package ptOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/10/26 19:44
 * [description]:
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 */
public class Offer57II {

    public static void main(String[] args) {
        Offer57II offer57II = new Offer57II();
        System.out.println(offer57II.findContinuousSequence(9));
    }

    //  从前往后做处理
    public int[][] findContinuousSequence(int target) {
        if (target <= 0) {
            return null;
        }

        List<int[]> res = new ArrayList<>();
        int limit = target / 2;
        for (int i = 1; i < limit + 1; i++) {
            int sum = 0;
            for (int j = i; sum < target; j++) {
                sum += j;
                if (sum == target) {
                    int[] aRes = new int[j - i + 1];
                    for (int k = 0; k < aRes.length; k++) {
                        aRes[k] = i + k;
                    }
                    // 保存记录数据
                    res.add(aRes);
                    break;
                }
            }

        }
        int[][] rtnRes = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            rtnRes[i] = res.get(i);
        }
        return rtnRes;
    }

}
