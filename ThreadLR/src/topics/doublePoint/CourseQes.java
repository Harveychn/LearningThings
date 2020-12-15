package topics.doublePoint;

/**
 * author: zhengxiaohui
 * create time: 2020/11/26 19:18
 * description: TODO
 */
public class CourseQes {

    public static void main(String[] args) {
        CourseQes qes = new CourseQes();
        System.out.println(qes.mySqrt(8));
    }

    public int mySqrt(int x) {
        long left = 0;
        long right = Integer.MAX_VALUE;

        while (left < right) {
            long mid = (left + right + 1) >>> 1;
            long s = mid * mid;
            if (s > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int) left;
    }

    /**
     * Forward declaration of guess API.
     *
     * @param num your guess
     * @return -1 if num is lower than the guess number
     * 1 if num is higher than the guess number
     * otherwise return 0
     * int guess(int num);
     */
    public int guessNumber(int n) {

        return -1;
    }
}
