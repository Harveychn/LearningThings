package reviews;

/**
 * author: zhengxiaohui
 * create time: 2020/11/4 9:09
 * description: TODO
 */
public class RefValDemo {

    static class Writer {
        private int value;

        public Writer(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Writer a = new Writer(123);
        Writer b = new Writer(123);


        modify(a, b);
        System.out.println(a.value);
        System.out.println(b.value);
    }

    public static void modify(Writer a, Writer b) {
        a.setValue(321);

        b = new Writer(22);
    }
}
